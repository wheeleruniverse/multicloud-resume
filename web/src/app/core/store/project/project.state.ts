import {MonthYear} from "../../../shared/model/month-year.model";
import {Skill} from "../skill/skill.state";

export interface ProjectState {
  data: Project[];
}

export interface Project {
  id: string;
  name: string;
  blog: string;
  code: string;
  description: string;
  end: MonthYear;
  skills: string[];
  start: MonthYear;
}

export interface ProjectCompositeState {
  projects: Project[];
  skills: Skill[];
}
