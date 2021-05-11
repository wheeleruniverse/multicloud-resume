import {Image} from "../shared/image.model";
import {Location} from "../shared/location.model";
import {MonthYear} from "../shared/month-year.model";

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
  type: EmploymentType;
}

export enum EmploymentType {
  Contract = "Contract",
  FullTime = "Full-time",
  Seasonal = "Seasonal",
}
