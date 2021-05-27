import {ExperienceState, initialExperienceState} from "./experience.state";
import {ExperienceActions, ExperienceActionType} from "./experience.actions";

export function experienceReducer(
  state: ExperienceState = initialExperienceState,
  action: ExperienceActions
){
  switch(action.type){
    case ExperienceActionType.RetrieveSuccess:
      return {...state, ...action.state};
    default:
      return state;
  }
}
