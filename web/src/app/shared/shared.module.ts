import { CommonModule } from '@angular/common';
import { IvyCarouselModule } from 'angular-responsive-carousel';
import { MatCardModule } from '@angular/material/card';
import { MatChipsModule } from '@angular/material/chips';
import { MatDividerModule } from '@angular/material/divider';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatSliderModule } from '@angular/material/slider';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { MatTooltipModule } from '@angular/material/tooltip';
import { NgModule } from '@angular/core';

import { CarouselComponent } from './component/carousel/carousel.component';
import { LocationPipe } from './pipe/location.pipe';
import { MonthYearPipe } from './pipe/month-year.pipe';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule } from '@angular/material/dialog';
import { ProjectInfoDialogComponent } from '../project/info-dialog/project-info-dialog.component';
import { MatButtonModule } from '@angular/material/button';
import {ProjectArchitectureDialogComponent} from '../project/architecture-dialog/project-architecture-dialog.component';

@NgModule({
  declarations: [
    CarouselComponent,
    LocationPipe,
    MonthYearPipe,
    ProjectArchitectureDialogComponent,
    ProjectInfoDialogComponent,
  ],
  exports: [
    CarouselComponent,
    CommonModule,
    MatButtonModule,
    MatCardModule,
    MatChipsModule,
    MatDialogModule,
    MatDividerModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatSliderModule,
    MatSnackBarModule,
    MatSortModule,
    MatTableModule,
    MatTooltipModule,
    LocationPipe,
    MonthYearPipe,
  ],
  imports: [
    CommonModule,
    MatButtonModule,
    MatChipsModule,
    MatDialogModule,
    MatDividerModule,
    MatIconModule,
    IvyCarouselModule,
  ],
})
export class SharedModule {}
