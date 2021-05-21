export enum ViewType {
  About,
  Certification,
  Education,
  Experience,
  Project,
  Skill
}

export interface View {
  shouldEnable: boolean;
  shouldRender: boolean;
}
