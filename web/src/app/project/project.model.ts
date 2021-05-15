
import {MonthYear} from "../shared/month-year.model";

export interface Project {
  id: number;
  blog: string;
  code: string;
  description: string;
  end: MonthYear;
  name: string;
  start: MonthYear;
  skillIds: number[]; //TODO:
}
