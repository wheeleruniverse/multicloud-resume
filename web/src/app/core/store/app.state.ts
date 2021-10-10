import {CertificationState} from './certification/certification.state';
import {EducationState} from './education/education.state';
import {ExperienceState} from './experience/experience.state';
import {ProjectState} from './project/project.state';
import {SkillState} from './skill/skill.state';
import {VisitorState} from './visitor/visitor.state';
import {ViewState} from './view/view.state';

export interface AppState {
  certification: CertificationState;
  education: EducationState;
  experience: ExperienceState;
  project: ProjectState;
  skill: SkillState;
  view: ViewState;
  visitor: VisitorState;
}
