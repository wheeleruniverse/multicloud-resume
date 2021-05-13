import {MonthYear} from "../shared/month-year.model";
import {Image} from "../shared/image.model";

export interface Certification {
  id: number;
  badge: Image;
  credentialId: string;
  description: string;
  expiry: MonthYear;
  issued: MonthYear;
  level: string,
  name: string;
  vendor: string;
}

export enum CertificationVendor {
  AWS = "Amazon Web Services",
  Azure = "Azure",
  GCP = "Google Cloud Platform",
  Oracle = "Oracle",
  SAFe = "Scaled Agile Framework"
}

export enum CertificationLevel {
  Foundational = 1,
  Associate = 2,
  Specialty = 3,
  Professional = 4
}
