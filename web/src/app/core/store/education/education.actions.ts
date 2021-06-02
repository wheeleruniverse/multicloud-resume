import { Action } from '@ngrx/store';
import { EducationState } from './education.state';

export enum EducationActionType {
  Retrieve = '[Education] Retrieve',
  RetrieveSuccess = '[Education] Retrieve Success',
}

export class EducationRetrieveAction implements Action {
  readonly type = EducationActionType.Retrieve;
}

export class EducationRetrieveSuccessAction implements Action {
  readonly type = EducationActionType.RetrieveSuccess;
  constructor(public state: EducationState) {}
}

export type EducationActions =
  | EducationRetrieveAction
  | EducationRetrieveSuccessAction;
