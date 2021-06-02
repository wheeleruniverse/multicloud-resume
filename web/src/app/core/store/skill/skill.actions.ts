import { Action } from '@ngrx/store';
import { SkillState } from './skill.state';

export enum SkillActionType {
  Retrieve = '[Skill] Retrieve',
  RetrieveSuccess = '[Skill] Retrieve Success',
}

export class SkillRetrieveAction implements Action {
  readonly type = SkillActionType.Retrieve;
}

export class SkillRetrieveSuccessAction implements Action {
  readonly type = SkillActionType.RetrieveSuccess;
  constructor(public state: SkillState) {}
}

export type SkillActions = SkillRetrieveAction | SkillRetrieveSuccessAction;
