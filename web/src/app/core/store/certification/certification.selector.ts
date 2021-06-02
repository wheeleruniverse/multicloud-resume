import { createFeatureSelector } from '@ngrx/store';
import { CertificationState } from './certification.state';
import { AppState } from '../app.state';

export const certificationStateSelector =
  createFeatureSelector<AppState, CertificationState>('certification');
