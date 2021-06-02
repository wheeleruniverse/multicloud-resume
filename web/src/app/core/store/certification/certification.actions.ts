import { Action } from '@ngrx/store';
import { CertificationState } from './certification.state';

export enum CertificationActionType {
  Retrieve = '[Certification] Retrieve',
  RetrieveSuccess = '[Certification] Retrieve Success',
}

export class CertificationRetrieveAction implements Action {
  readonly type = CertificationActionType.Retrieve;
}

export class CertificationRetrieveSuccessAction implements Action {
  readonly type = CertificationActionType.RetrieveSuccess;
  constructor(public state: CertificationState) {}
}

export type CertificationActions =
  | CertificationRetrieveAction
  | CertificationRetrieveSuccessAction;
