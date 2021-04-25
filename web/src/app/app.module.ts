import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {IvyCarouselModule} from "angular-responsive-carousel";
import {MatDividerModule} from '@angular/material/divider';
import {EducationComponent} from "./education/education.component";
import {ExperienceComponent} from "./experience/experience.component";
import {ProjectsComponent} from "./projects/projects.component";
import {SkillsComponent} from "./skills/skills.component";
import {MonthYearPipe} from "./shared/month-year.pipe";
import {LocationPipe} from "./shared/location.pipe";
import { CarouselComponent } from './shared/carousel.component';
import {CertificationComponent} from "./certification/certification.component";
import {MatSliderModule} from "@angular/material/slider";

@NgModule({
  declarations: [
    AppComponent,
    CertificationComponent,
    EducationComponent,
    ExperienceComponent,
    ProjectsComponent,
    SkillsComponent,
    MonthYearPipe,
    LocationPipe,
    CarouselComponent,
  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    IvyCarouselModule,
    MatDividerModule,
    MatSliderModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
