import { initialSkillState, SkillState } from './skill.state';
import { SkillActions, SkillActionType } from './skill.actions';

export function skillReducer(
  state: SkillState = initialSkillState,
  action: SkillActions
): SkillState {
  switch (action.type) {
    case SkillActionType.RetrieveSuccess:
      return { ...state, ...action.state };
    default:
      return state;
  }
}
