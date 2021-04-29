
export interface Skill {
  id: number;
  level: SkillLevel;
  skill: string;
  type: string;

  // foreign
  _filterByProjectIds: string[];
}

export enum SkillLevel {
  Novice = 1,
  Competent = 2,
  Proficient = 3,
  Expert = 4,
  Master = 5
}
