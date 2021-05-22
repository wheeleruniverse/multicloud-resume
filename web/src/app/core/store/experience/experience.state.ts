import {Image} from "../../../shared/model/image.model";
import {Location} from "../../../shared/model/location.model";
import {MonthYear} from "../../../shared/model/month-year.model";

export interface ExperienceState {
  data: Experience[];
}

export interface Experience {
  id: number;
  name: string;
  description: string;
  end: MonthYear;
  image: Image;
  location: Location;
  project: string;
  role: string;
  start: MonthYear;
  type: string;
}
