import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MockexamSharedModule } from 'app/shared/shared.module';
import { ExamComponent } from './exam.component';
import { ExamDetailComponent } from './exam-detail.component';
import { ExamUpdateComponent } from './exam-update.component';
import { ExamDeleteDialogComponent } from './exam-delete-dialog.component';
import { examRoute } from './exam.route';

@NgModule({
  imports: [MockexamSharedModule, RouterModule.forChild(examRoute)],
  declarations: [ExamComponent, ExamDetailComponent, ExamUpdateComponent, ExamDeleteDialogComponent],
  entryComponents: [ExamDeleteDialogComponent],
})
export class MockexamExamModule {}
