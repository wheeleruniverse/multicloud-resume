import { CertificationState, initialCertificationState } from './certification.state';
import { CertificationActions, CertificationActionType } from './certification.actions';

export function certificationReducer(
  state: CertificationState = initialCertificationState,
  action: CertificationActions
): CertificationState {
  switch (action.type) {
    case CertificationActionType.RetrieveSuccess:
      return { ...state, ...action.state };
    default:
      return state;
  }
}
