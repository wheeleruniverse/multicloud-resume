import {createFeatureSelector} from "@ngrx/store";
import {ExperienceState} from "./experience.state";
import {AppState} from "../app.state";

export const experienceStateSelector = createFeatureSelector<AppState, ExperienceState>(
  'experience'
);

