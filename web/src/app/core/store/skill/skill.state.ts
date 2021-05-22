import {MonthYear} from "../../../shared/model/month-year.model";
import {MetaData} from "../../../shared/model/meta-data.model";

export interface SkillState {
  data: Skill[];
  meta: SkillMeta;
}

export interface Skill {
  id: number;
  level: string;
  name: string;
  type: string;

  // foreign
  _filterByProjectIds: string[]; //TODO:
}

export interface SkillMeta {
  levels: MetaData[];
}
