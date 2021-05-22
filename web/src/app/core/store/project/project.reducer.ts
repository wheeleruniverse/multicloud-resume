import {ProjectState} from "./project.state";
import {ProjectActions, ProjectActionType} from "./project.actions";

export function projectReducer(state: ProjectState, action: ProjectActions){
  switch(action.type){
    case ProjectActionType.RetrieveSuccess:
      return action.state;
    default:
      return state;
  }
}
