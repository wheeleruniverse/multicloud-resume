
export interface Skill {
  id: number;
  level: SkillLevel;
  skill: string;
  type: string;
}

export enum SkillLevel {
  Novice = 1,
  Competent = 2,
  Proficient = 3,
  Expert = 4,
  Master = 5
}
