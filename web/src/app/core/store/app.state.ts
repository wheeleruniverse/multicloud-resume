import {CertificationState} from "./certification/certification.state";
import {EducationState} from "./education/education.state";

export interface AppState {
  certification: CertificationState;
  education: EducationState;
}
