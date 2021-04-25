
import {MonthYear} from "../shared/models/month-year";
import {Image} from "../shared/models/image";
import {Location} from "../shared/models/location";

export interface Experience {
  id: number;
  company: string;
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
