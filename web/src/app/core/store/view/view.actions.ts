import {Action} from '@ngrx/store';

export enum ViewActionType {
  SetEnable = '[View] Set Enable',
  SetRender = '[View] Set Render',
}

export class ViewSetEnableAction implements Action {
  readonly type = ViewActionType.SetEnable;
  constructor(public name: string, public value: boolean){}
}

export class ViewSetRenderAction implements Action {
  readonly type = ViewActionType.SetRender;
  constructor(public name: string, public value: boolean){}
}

export type ViewActions =
  | ViewSetEnableAction
  | ViewSetRenderAction;
