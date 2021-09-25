import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { EducationComponent } from './education/education.component';
import { ExperienceComponent } from './experience/experience.component';
import { ProjectComponent } from './project/project.component';
import { SkillComponent } from './skill/skill.component';
import { CertificationComponent } from './certification/certification.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { VisitorComponent } from './visitor/visitor.component';
import { AboutComponent } from './about/about.component';
import { SharedModule } from './shared/shared.module';
import { CoreModule } from './core/core.module';
import { CookieService } from 'ngx-cookie-service';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { SocialComponent } from './social/social.component';

@NgModule({
  bootstrap: [AppComponent],
  declarations: [
    AboutComponent,
    AppComponent,
    CertificationComponent,
    EducationComponent,
    ExperienceComponent,
    ProjectComponent,
    SocialComponent,
    SkillComponent,
    VisitorComponent,
  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    CoreModule,
    FontAwesomeModule,
    HttpClientModule,
    SharedModule,
  ],
  providers: [CookieService, HttpClient],
})
export class AppModule {}
