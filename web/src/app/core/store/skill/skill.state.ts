import { MetaData } from '../../../shared/model/meta-data.model';

export interface SkillState {
  data: Skill[];
  meta: SkillMeta;
}

export interface Skill {
  id: string;
  name: string;
  level: string;
  projects: string[];
  type: string;
}

export interface SkillMeta {
  levels: MetaData[];
}

export const initialSkillState: SkillState = {
  data: undefined,
  meta: undefined,
};
