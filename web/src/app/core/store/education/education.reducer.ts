import {EducationState} from "./education.state";
import {EducationActions, EducationActionType} from "./education.actions";

export function educationReducer(state: EducationState, action: EducationActions){
  switch(action.type){
    case EducationActionType.RetrieveSuccess:
      return action.state;
    default:
      return state;
  }
}
