import {environment} from "../../../environments/environment";

export const backend = {
  certification: {
    retrieve: `${environment.backend}/certification/retrieve`,
  },
  education: {
    retrieve: `${environment.backend}/education/retrieve`,
  },
  experience: {
    retrieve: `${environment.backend}/experience/retrieve`,
  },
  project: {
    retrieve: `${environment.backend}/project/retrieve`,
  },
  skill: {
    retrieve: `${environment.backend}/skill/retrieve`,
  },
  visitor: {
    count: `${environment.backend}/visitor/count`,
    create: `${environment.backend}/visitor/create`,
    retrieve: `${environment.backend}/visitor/retrieve`,
  },
};
