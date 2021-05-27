import {Image} from "../../../shared/model/image.model";
import {Location} from "../../../shared/model/location.model";
import {CertificationState} from "../certification/certification.state";

export interface EducationState {
  data: Education[];
}

export interface Education {
  id: string;
  name: string;
  degree: string;
  description: string;
  end: number;
  image: Image;
  field: string;
  location: Location;
  start: number;
}

export const initialEducationState: EducationState = {
  data: undefined
}
