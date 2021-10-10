import {ViewState} from './view.state';
import {ViewActions} from './view.actions';
import {initialViewState, viewEntityStateAdapter} from './view.state';
import {ViewActionType, ViewSetEnableAction, ViewSetRenderAction} from './view.actions';

export function viewReducer(
  state: ViewState = initialViewState,
  action: ViewActions
): ViewState {
  switch (action.type) {
    case ViewActionType.SetEnable:
      return setEnable(state, action);
    case ViewActionType.SetRender:
      return setRender(state, action);
    default:
      return state;
  }
}

function setEnable(state: ViewState, action: ViewSetEnableAction): ViewState {
  const view = state.data.entities[action.name];
  return {
    ...state,
    data: viewEntityStateAdapter.upsertOne(
      {
        ...view,
        enable: action.value
      },
      state.data
    )
  };
}

function setRender(state: ViewState, action: ViewSetRenderAction): ViewState {
  const view = state.data.entities[action.name];
  return {
    ...state,
    data: viewEntityStateAdapter.upsertOne(
      {
        ...view,
        render: action.value
      },
      state.data
    )
  };
}
