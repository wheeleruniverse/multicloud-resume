import {Dictionary, EntityState} from '@ngrx/entity';
import {View, viewEntityStateAdapter, ViewState} from './view.state';

export function createViewState(
  partialModel?: Partial<EntityState<View>>
): ViewState {
  const defaultModel = {
    data: {
      ids: ['v1', 'v2'],
      entities: createViewDictionary([
        { name: 'v1' }, { name: 'v2' }
      ])
    }
  };
  return { ...defaultModel, ...partialModel };
}

export function createView(
  partialModel?: Partial<View>
): View {
  const defaultModel = {
    name: 'v1',
    enable: true,
    render: false
  };
  return { ...defaultModel, ...partialModel };
}

export function createViewDictionary(
  partialModels?: Partial<View>[]
): Dictionary<View> {
  const emptyEntityState: EntityState<View> = {
    ids: [],
    entities: {}
  };
  const viewEntities: View[] = partialModels.map(partial => createView(partial));
  return viewEntityStateAdapter.addMany(viewEntities, emptyEntityState).entities;
}
