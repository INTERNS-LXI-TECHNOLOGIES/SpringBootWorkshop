import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize, map } from 'rxjs/operators';

import { IAddress, Address } from '../address.model';
import { AddressService } from '../service/address.service';
import { IContact } from 'app/entities/contact/contact.model';
import { ContactService } from 'app/entities/contact/service/contact.service';

@Component({
  selector: 'jhi-address-update',
  templateUrl: './address-update.component.html',
})
export class AddressUpdateComponent implements OnInit {
  isSaving = false;

  contactsSharedCollection: IContact[] = [];

  editForm = this.fb.group({
    id: [],
    placeName: [],
    country: [],
    contact: [],
    contact: [],
  });

  constructor(
    protected addressService: AddressService,
    protected contactService: ContactService,
    protected activatedRoute: ActivatedRoute,
    protected fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ address }) => {
      this.updateForm(address);

      this.loadRelationshipsOptions();
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const address = this.createFromForm();
    if (address.id !== undefined) {
      this.subscribeToSaveResponse(this.addressService.update(address));
    } else {
      this.subscribeToSaveResponse(this.addressService.create(address));
    }
  }

  trackContactById(_index: number, item: IContact): number {
    return item.id!;
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IAddress>>): void {
    result.pipe(finalize(() => this.onSaveFinalize())).subscribe({
      next: () => this.onSaveSuccess(),
      error: () => this.onSaveError(),
    });
  }

  protected onSaveSuccess(): void {
    this.previousState();
  }

  protected onSaveError(): void {
    // Api for inheritance.
  }

  protected onSaveFinalize(): void {
    this.isSaving = false;
  }

  protected updateForm(address: IAddress): void {
    this.editForm.patchValue({
      id: address.id,
      placeName: address.placeName,
      country: address.country,
      contact: address.contact,
      contact: address.contact,
    });

    this.contactsSharedCollection = this.contactService.addContactToCollectionIfMissing(
      this.contactsSharedCollection,
      address.contact,
      address.contact
    );
  }

  protected loadRelationshipsOptions(): void {
    this.contactService
      .query()
      .pipe(map((res: HttpResponse<IContact[]>) => res.body ?? []))
      .pipe(
        map((contacts: IContact[]) =>
          this.contactService.addContactToCollectionIfMissing(
            contacts,
            this.editForm.get('contact')!.value,
            this.editForm.get('contact')!.value
          )
        )
      )
      .subscribe((contacts: IContact[]) => (this.contactsSharedCollection = contacts));
  }

  protected createFromForm(): IAddress {
    return {
      ...new Address(),
      id: this.editForm.get(['id'])!.value,
      placeName: this.editForm.get(['placeName'])!.value,
      country: this.editForm.get(['country'])!.value,
      contact: this.editForm.get(['contact'])!.value,
      contact: this.editForm.get(['contact'])!.value,
    };
  }
}
