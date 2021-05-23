import {MonthYear} from "../../../shared/model/month-year.model";

export interface ProjectState {
  data: Project[];
}

export interface Project {
  id: number;
  name: string;
  blog: string;
  code: string;
  description: string;
  end: MonthYear;
  skills: string[];
  start: MonthYear;
}
