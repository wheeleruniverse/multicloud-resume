
import {MonthYear} from "../shared/month-year.model";

export interface Project {
  id: number;
  blog: string;
  code: string;
  description: string;
  end: MonthYear;
  name: string;
  skillIds: number[]; //TODO: Associate to Skill Model
  start: MonthYear;
}
