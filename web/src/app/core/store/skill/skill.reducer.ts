import {SkillState} from "./skill.state";
import {SkillActions, SkillActionType} from "./skill.actions";

export function skillReducer(state: SkillState, action: SkillActions){
  switch(action.type){
    case SkillActionType.RetrieveSuccess:
      return action.state;
    default:
      return state;
  }
}
