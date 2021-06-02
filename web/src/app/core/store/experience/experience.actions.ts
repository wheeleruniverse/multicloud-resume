import { Action } from '@ngrx/store';
import { ExperienceState } from './experience.state';

export enum ExperienceActionType {
  Retrieve = '[Experience] Retrieve',
  RetrieveSuccess = '[Experience] Retrieve Success',
}

export class ExperienceRetrieveAction implements Action {
  readonly type = ExperienceActionType.Retrieve;
}

export class ExperienceRetrieveSuccessAction implements Action {
  readonly type = ExperienceActionType.RetrieveSuccess;
  constructor(public state: ExperienceState) {}
}

export type ExperienceActions = ExperienceRetrieveAction | ExperienceRetrieveSuccessAction;
