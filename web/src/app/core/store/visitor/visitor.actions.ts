import { Action } from '@ngrx/store';
import { VisitorState } from './visitor.state';

export enum VisitorActionType {
  Count = '[Visitor] Count',
  CountSuccess = '[Visitor] Count Success',
  Increment = '[Visitor] Increment',
  IncrementFailure = '[Visitor] Increment Failure',
  IncrementSuccess = '[Visitor] Increment Success',
}

export class VisitorCountAction implements Action {
  readonly type = VisitorActionType.Count;
}

export class VisitorCountSuccessAction implements Action {
  readonly type = VisitorActionType.CountSuccess;
  constructor(public state: VisitorState) {}
}

export class VisitorIncrementAction implements Action {
  readonly type = VisitorActionType.Increment;
}

export class VisitorIncrementFailureAction implements Action {
  readonly type = VisitorActionType.IncrementFailure;
  constructor(public e?: any) {}
}

export class VisitorIncrementSuccessAction implements Action {
  readonly type = VisitorActionType.IncrementSuccess;
}

export type VisitorActions =
  | VisitorCountAction
  | VisitorCountSuccessAction
  | VisitorIncrementAction
  | VisitorIncrementFailureAction
  | VisitorIncrementSuccessAction;
