import {ExperienceState} from "./experience.state";
import {ExperienceActions, ExperienceActionType} from "./experience.actions";

export function experienceReducer(state: ExperienceState, action: ExperienceActions){
  switch(action.type){
    case ExperienceActionType.RetrieveSuccess:
      return action.state;
    default:
      return state;
  }
}
