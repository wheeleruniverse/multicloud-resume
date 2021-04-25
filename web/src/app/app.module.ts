import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {IvyCarouselModule} from "angular-responsive-carousel";
import {MatDividerModule} from '@angular/material/divider';
import {CertificationsComponent} from "./certifications/certifications.component";
import {EducationComponent} from "./education/education.component";
import {ExperienceComponent} from "./experience/experience.component";
import {ProjectsComponent} from "./projects/projects.component";
import {SkillsComponent} from "./skills/skills.component";
import {FormatDatePipe} from "./shared/pipe/format-date.pipe";
import {FormatLocationPipe} from "./shared/pipe/format-location.pipe";

@NgModule({
  declarations: [
    AppComponent,
    CertificationsComponent,
    EducationComponent,
    ExperienceComponent,
    ProjectsComponent,
    SkillsComponent,
    FormatDatePipe,
    FormatLocationPipe,
  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    IvyCarouselModule,
    MatDividerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
