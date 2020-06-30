import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'exam',
        loadChildren: () => import('./exam/exam.module').then(m => m.MockexamExamModule),
      },
      {
        path: 'role',
        loadChildren: () => import('./role/role.module').then(m => m.MockexamRoleModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class MockexamEntityModule {}
