import {MonthYear} from "../../../shared/model/month-year.model";
import {MetaData} from "../../../shared/model/meta-data.model";

export interface CertificationState {
  data: Certification[];
  meta: CertificationMeta;
}

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

export interface CertificationMeta {
  levels: MetaData[];
  vendors: MetaData[];
}

// export const certificationAdapter = createEntityAdapter<Certification>({
//   selectId: model => model.id
// });

export const certificationInitialState: CertificationState = {
  data: undefined,
  meta: undefined
}
