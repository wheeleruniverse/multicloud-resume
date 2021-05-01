import {Image} from "../shared/image.model";
import {Location} from "../shared/location.model";

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
