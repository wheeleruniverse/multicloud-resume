import {Image} from "../../../shared/model/image.model";
import {Location} from "../../../shared/model/location.model";

export interface EducationState {
  data: Education[];
}

export interface Education {
  id: string;
  name: string;
  degree: string;
  descriptions: string[];
  end: number;
  image: Image;
  field: string;
  location: Location;
  start: number;
}

export const initialEducationState: EducationState = {
  data: undefined
}
