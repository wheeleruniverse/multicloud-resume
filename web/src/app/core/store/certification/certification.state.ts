import {MonthYear} from "../../../shared/model/month-year.model";
import {MetaData} from "../../../shared/model/meta-data.model";

export interface CertificationState {
  data: Certification[];
  meta: CertificationMeta;
}

export interface Certification {
  id: string;
  name: string;
  credential: string;
  descriptions: string[];
  expiry: MonthYear;
  issued: MonthYear;
  level: string,
  vendor: string;
}

export interface CertificationMeta {
  levels: MetaData[];
  vendors: MetaData[];
}

export const initialCertificationState: CertificationState = {
  data: undefined,
  meta: undefined
}
