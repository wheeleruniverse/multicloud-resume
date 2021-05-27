import {initialProjectState, ProjectState} from "./project.state";
import {ProjectActions, ProjectActionType} from "./project.actions";

export function projectReducer(
  state: ProjectState = initialProjectState,
  action: ProjectActions
){
  switch(action.type){
    case ProjectActionType.RetrieveSuccess:
      return {...state, ...action.state};
    default:
      return state;
  }
}
