import { Action } from '@ngrx/store';
import { ProjectState } from './project.state';

export enum ProjectActionType {
  Retrieve = '[Project] Retrieve',
  RetrieveSuccess = '[Project] Retrieve Success',
}

export class ProjectRetrieveAction implements Action {
  readonly type = ProjectActionType.Retrieve;
}

export class ProjectRetrieveSuccessAction implements Action {
  readonly type = ProjectActionType.RetrieveSuccess;
  constructor(public state: ProjectState) {}
}

export type ProjectActions = ProjectRetrieveAction | ProjectRetrieveSuccessAction;
