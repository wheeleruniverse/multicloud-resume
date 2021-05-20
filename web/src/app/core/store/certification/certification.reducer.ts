import {certificationInitialState, CertificationState} from "./certification.state";
import {CertificationActions, CertificationActionType} from "./certification.actions";

export function certificationReducer(state: CertificationState, action: CertificationActions){
  switch(action.type){
    case CertificationActionType.Retrieve:
      return certificationInitialState;
    case CertificationActionType.RetrieveSuccess:
      return action.state;
    default:
      return state;
  }
}
