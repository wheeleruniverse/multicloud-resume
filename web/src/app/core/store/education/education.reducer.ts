import {EducationState, initialEducationState} from "./education.state";
import {EducationActions, EducationActionType} from "./education.actions";

export function educationReducer(
  state: EducationState = initialEducationState,
  action: EducationActions
){
  switch(action.type){
    case EducationActionType.RetrieveSuccess:
      return {...state, ...action.state};
    default:
      return state;
  }
}
