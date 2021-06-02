import { createFeatureSelector, createSelector } from '@ngrx/store';
import { ProjectCompositeState, ProjectState } from './project.state';
import { AppState } from '../app.state';
import { skillStateSelector } from '../skill/skill.selector';

export const projectStateSelector =
  createFeatureSelector<AppState, ProjectState>('project');

export const projectCompositeStateSelector = createSelector(
  projectStateSelector,
  skillStateSelector,
  (project, skill) => {
    const composite: ProjectCompositeState = {
      projects: project?.data,
      skills: skill?.data,
    };
    return composite;
  }
);
