import {createFeatureSelector} from "@ngrx/store";
import {ProjectState} from "./project.state";
import {AppState} from "../app.state";

export const projectStateSelector = createFeatureSelector<AppState, ProjectState>(
  'project'
);

