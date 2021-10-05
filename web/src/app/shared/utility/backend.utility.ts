import {environment} from '../../../environments/environment';

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
    increment: `${environment.backend}/visitor/increment`,
  },
};

export function getStorageUrl(entity: string, id: string, suffix: string): string {
  if (!entity || !id || !suffix){
    return undefined;
  }
  return `${environment.storage}/${entity}/${id}/${suffix}`;
}
