import {createEntityAdapter, EntityState} from '@ngrx/entity';

export const viewEntityStateAdapter = createEntityAdapter<View>({
  selectId: (view) => view.name,
  sortComparer: (view1, view2) => view1.name.localeCompare(view2.name),
});

export interface ViewState {
  data: EntityState<View>;
}

export interface View {
  name: string;
  enable: boolean;
  render: boolean;
}

export const initialViewState: ViewState = {
  data: {
    ids: [
      'about',
      'certification',
      'education',
      'experience',
      'project',
      'skill',
      'visitor',
    ],
    entities: {
      about: createDefaultView('about'),
      certification: createDefaultView('certification'),
      education: createDefaultView('education'),
      experience: createDefaultView('experience'),
      project: createDefaultView('project'),
      skill: createDefaultView('skill'),
      visitor: {
        ...createDefaultView('visitor'),
        render: true
      }
    }
  }
};

function createDefaultView(name: string): View {
  return {
    name,
    enable: true,
    render: false
  };
}
