import {createFeatureSelector} from "@ngrx/store";
import {SkillState} from "./skill.state";
import {AppState} from "../app.state";

export const skillStateSelector = createFeatureSelector<AppState, SkillState>(
  'skill'
);

