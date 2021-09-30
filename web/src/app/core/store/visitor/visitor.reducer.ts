import {initialVisitorState, VisitorState} from './visitor.state';
import {VisitorActions, VisitorActionType} from './visitor.actions';

export function visitorReducer(
  state: VisitorState = initialVisitorState,
  action: VisitorActions
): VisitorState {
  switch (action.type) {
    case VisitorActionType.CountSuccess:
      return { ...state, ...action.state };
    case VisitorActionType.IncrementSuccess:
      return { ...state, value: state.value + 1 };
    default:
      return state;
  }
}
