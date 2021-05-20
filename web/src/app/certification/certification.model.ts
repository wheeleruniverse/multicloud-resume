import {MonthYear} from "../shared/model/month-year.model";
import {MetaData} from "../shared/model/meta-data.model";

export interface Certification {
  id: number;
  credential: string;
  description: string;
  expiry: MonthYear;
  issued: MonthYear;
  level: string,
  name: string;
  vendor: string;
}

export interface CertificationDto {
  data: Certification[];
  meta: CertificationMeta;
}

export interface CertificationMeta {
  levels: MetaData[];
  vendors: MetaData[];
}
