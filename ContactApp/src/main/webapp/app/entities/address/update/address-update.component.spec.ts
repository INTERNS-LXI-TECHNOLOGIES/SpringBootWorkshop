import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { of, Subject, from } from 'rxjs';

import { AddressService } from '../service/address.service';
import { IAddress, Address } from '../address.model';
import { IContact } from 'app/entities/contact/contact.model';
import { ContactService } from 'app/entities/contact/service/contact.service';

import { AddressUpdateComponent } from './address-update.component';

describe('Address Management Update Component', () => {
  let comp: AddressUpdateComponent;
  let fixture: ComponentFixture<AddressUpdateComponent>;
  let activatedRoute: ActivatedRoute;
  let addressService: AddressService;
  let contactService: ContactService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, RouterTestingModule.withRoutes([])],
      declarations: [AddressUpdateComponent],
      providers: [
        FormBuilder,
        {
          provide: ActivatedRoute,
          useValue: {
            params: from([{}]),
          },
        },
      ],
    })
      .overrideTemplate(AddressUpdateComponent, '')
      .compileComponents();

    fixture = TestBed.createComponent(AddressUpdateComponent);
    activatedRoute = TestBed.inject(ActivatedRoute);
    addressService = TestBed.inject(AddressService);
    contactService = TestBed.inject(ContactService);

    comp = fixture.componentInstance;
  });

  describe('ngOnInit', () => {
    it('Should call Contact query and add missing value', () => {
      const address: IAddress = { id: 456 };
      const contact: IContact = { id: 31826 };
      address.contact = contact;
      const contact: IContact = { id: 34263 };
      address.contact = contact;

      const contactCollection: IContact[] = [{ id: 20933 }];
      jest.spyOn(contactService, 'query').mockReturnValue(of(new HttpResponse({ body: contactCollection })));
      const additionalContacts = [contact, contact];
      const expectedCollection: IContact[] = [...additionalContacts, ...contactCollection];
      jest.spyOn(contactService, 'addContactToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ address });
      comp.ngOnInit();

      expect(contactService.query).toHaveBeenCalled();
      expect(contactService.addContactToCollectionIfMissing).toHaveBeenCalledWith(contactCollection, ...additionalContacts);
      expect(comp.contactsSharedCollection).toEqual(expectedCollection);
    });

    it('Should update editForm', () => {
      const address: IAddress = { id: 456 };
      const contact: IContact = { id: 25881 };
      address.contact = contact;
      const contact: IContact = { id: 62106 };
      address.contact = contact;

      activatedRoute.data = of({ address });
      comp.ngOnInit();

      expect(comp.editForm.value).toEqual(expect.objectContaining(address));
      expect(comp.contactsSharedCollection).toContain(contact);
      expect(comp.contactsSharedCollection).toContain(contact);
    });
  });

  describe('save', () => {
    it('Should call update service on save for existing entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<Address>>();
      const address = { id: 123 };
      jest.spyOn(addressService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ address });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: address }));
      saveSubject.complete();

      // THEN
      expect(comp.previousState).toHaveBeenCalled();
      expect(addressService.update).toHaveBeenCalledWith(address);
      expect(comp.isSaving).toEqual(false);
    });

    it('Should call create service on save for new entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<Address>>();
      const address = new Address();
      jest.spyOn(addressService, 'create').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ address });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: address }));
      saveSubject.complete();

      // THEN
      expect(addressService.create).toHaveBeenCalledWith(address);
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).toHaveBeenCalled();
    });

    it('Should set isSaving to false on error', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<Address>>();
      const address = { id: 123 };
      jest.spyOn(addressService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ address });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.error('This is an error!');

      // THEN
      expect(addressService.update).toHaveBeenCalledWith(address);
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).not.toHaveBeenCalled();
    });
  });

  describe('Tracking relationships identifiers', () => {
    describe('trackContactById', () => {
      it('Should return tracked Contact primary key', () => {
        const entity = { id: 123 };
        const trackResult = comp.trackContactById(0, entity);
        expect(trackResult).toEqual(entity.id);
      });
    });
  });
});
