import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {IvyCarouselModule} from "angular-responsive-carousel";
import {MatDividerModule} from '@angular/material/divider';
import {EducationComponent} from "./education/education.component";
import {ExperienceComponent} from "./experience/experience.component";
import {ProjectComponent} from "./project/project.component";
import {SkillComponent} from "./skill/skill.component";
import {MonthYearPipe} from "./shared/month-year.pipe";
import {LocationPipe} from "./shared/location.pipe";
import { CarouselComponent } from './shared/carousel.component';
import {CertificationComponent} from "./certification/certification.component";
import {MatSliderModule} from "@angular/material/slider";
import {MatTableModule} from "@angular/material/table";
import { MatPaginatorModule} from "@angular/material/paginator";
import {MatFormFieldControl, MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatSortModule} from "@angular/material/sort";

@NgModule({
  declarations: [
    AppComponent,
    CertificationComponent,
    EducationComponent,
    ExperienceComponent,
    ProjectComponent,
    SkillComponent,
    MonthYearPipe,
    LocationPipe,
    CarouselComponent,
  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    IvyCarouselModule,
    MatDividerModule,
    MatSliderModule,
    MatTableModule,
    MatPaginatorModule,
    MatFormFieldModule,
    MatInputModule,
    MatSortModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
