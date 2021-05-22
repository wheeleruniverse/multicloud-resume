import {Image} from "../../../shared/model/image.model";
import {Location} from "../../../shared/model/location.model";

export interface EducationState {
  data: Education[];
}

export interface Education {
  id: number;
  degree: string;
  description: string;
  end: number;
  image: Image;
  field: string;
  location: Location;
  name: string;
  start: number;
}
