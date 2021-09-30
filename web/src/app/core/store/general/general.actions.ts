import { Action } from '@ngrx/store';

export enum GeneralActionType {
  Error = '[General] Error',
  NoOp = '[General] No Operation',
}

export class ErrorAction implements Action {
  readonly type = GeneralActionType.Error;
  constructor(public e: any) {}
}

export class NoOpAction implements Action {
  readonly type = GeneralActionType.NoOp;
  constructor(public message: string) {}
}
