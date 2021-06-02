import { createFeatureSelector } from '@ngrx/store';
import { EducationState } from './education.state';
import { AppState } from '../app.state';

export const educationStateSelector =
  createFeatureSelector<AppState, EducationState>('education');
