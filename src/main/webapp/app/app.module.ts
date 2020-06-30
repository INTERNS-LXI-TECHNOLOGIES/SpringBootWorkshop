import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { MockexamSharedModule } from 'app/shared/shared.module';
import { MockexamCoreModule } from 'app/core/core.module';
import { MockexamAppRoutingModule } from './app-routing.module';
import { MockexamHomeModule } from './home/home.module';
import { MockexamEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ActiveMenuDirective } from './layouts/navbar/active-menu.directive';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    MockexamSharedModule,
    MockexamCoreModule,
    MockexamHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    MockexamEntityModule,
    MockexamAppRoutingModule,
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, ActiveMenuDirective, FooterComponent],
  bootstrap: [MainComponent],
})
export class MockexamAppModule {}
