import {createFeatureSelector, createSelector} from '@ngrx/store';
import { VisitorState } from './visitor.state';
import { AppState } from '../app.state';

const visitorStateSelector = createFeatureSelector<AppState, VisitorState>('visitor');

export const visitorValueSelector = createSelector(
  visitorStateSelector,
  (state) => state.value
)
