import {createFeatureSelector, createSelector} from '@ngrx/store';
import {viewEntityStateAdapter, ViewState} from './view.state';
import {AppState} from '../app.state';

const viewStateSelector = createFeatureSelector<AppState, ViewState>('view');

export const viewEntitiesSelector = createSelector(
  viewStateSelector,
  (state) => viewEntityStateAdapter.getSelectors().selectEntities(state.data)
);

export const viewEntitySelector = (name: string) => createSelector(
  viewEntitiesSelector,
  (entities) => entities[name]
);




