import {MetaData} from "../shared/meta-data.model";

export interface Skill {
  id: number;
  level: string;
  name: string;
  type: string;

  // foreign
  _filterByProjectIds: string[]; //TODO:
}

export interface SkillDto {
  data: Skill[];
  meta: SkillMeta;
}

export interface SkillMeta {
  levels: MetaData[];
}
