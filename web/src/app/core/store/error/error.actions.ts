import {Action} from "@ngrx/store";

export enum ErrorActionType {
  Error = "[Error] Error",
}

export class ErrorAction implements Action {
  readonly type = ErrorActionType.Error;
  constructor(public e: any) {}
}

export type ErrorActions =
  | ErrorAction;
