import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IExam, Exam } from 'app/shared/model/exam.model';
import { ExamService } from './exam.service';

@Component({
  selector: 'jhi-exam-update',
  templateUrl: './exam-update.component.html',
})
export class ExamUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    question: [],
    opt1: [],
    opt2: [],
    opt3: [],
    opt4: [],
    answer: [],
  });

  constructor(protected examService: ExamService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ exam }) => {
      this.updateForm(exam);
    });
  }

  updateForm(exam: IExam): void {
    this.editForm.patchValue({
      id: exam.id,
      question: exam.question,
      opt1: exam.opt1,
      opt2: exam.opt2,
      opt3: exam.opt3,
      opt4: exam.opt4,
      answer: exam.answer,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const exam = this.createFromForm();
    if (exam.id !== undefined) {
      this.subscribeToSaveResponse(this.examService.update(exam));
    } else {
      this.subscribeToSaveResponse(this.examService.create(exam));
    }
  }

  private createFromForm(): IExam {
    return {
      ...new Exam(),
      id: this.editForm.get(['id'])!.value,
      question: this.editForm.get(['question'])!.value,
      opt1: this.editForm.get(['opt1'])!.value,
      opt2: this.editForm.get(['opt2'])!.value,
      opt3: this.editForm.get(['opt3'])!.value,
      opt4: this.editForm.get(['opt4'])!.value,
      answer: this.editForm.get(['answer'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IExam>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }
}
