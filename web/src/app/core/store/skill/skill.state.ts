import {MetaData} from "../../../shared/model/meta-data.model";

export interface SkillState {
  data: Skill[];
  meta: SkillMeta;
}

export interface Skill {
  id: string;
  name: string;
  level: string;
  type: string;

  // foreign
  _filterByProjectIds: string[]; //TODO:
}

export interface SkillMeta {
  levels: MetaData[];
}
