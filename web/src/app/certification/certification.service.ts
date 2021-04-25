import {Injectable} from '@angular/core';
import {Observable, of} from "rxjs";
import {Certification, CertificationLevel, CertificationVendor} from "./certification.model";
import {Month} from "../shared/month-year.model";

@Injectable({
  providedIn: 'root'
})
export class CertificationService {

  constructor() { }

  get(): Observable<Certification[]> {

    const certifications: Certification[] = [
      {
        id: 1,
        badge: null,
        credentialId: 'R9P1ZDJC2BEE1LS4',
        description: 'The AWS Certified Cloud Practitioner examination is intended for individuals who have the knowledge and skills necessary to effectively demonstrate an overall understanding of the AWS Cloud, independent of specific technical roles addressed by other AWS Certifications.',
        expiry: {
          month: Month.Jul,
          year: 2023
        },
        issued: {
          month: Month.Dec,
          year: 2018
        },
        level: CertificationLevel.Foundational,
        name: 'Cloud Practitioner',
        vendor: CertificationVendor.AWS
      },
      {
        id: 2,
        badge: null,
        credentialId: 'KNVXP1W2LFF4QFKS',
        description: 'The AWS Certified Developer - Associate examination is intended for individuals who perform a development role and have one or more years of hands-on experience developing and maintaining an AWS-based application.',
        expiry: {
          month: Month.Jul,
          year: 2023
        },
        issued: {
          month: Month.Jun,
          year: 2018
        },
        level: CertificationLevel.Associate,
        name: 'Developer Associate',
        vendor: CertificationVendor.AWS
      },
      {
        id: 3,
        badge: null,
        credentialId: '6JGG02H2CJREQFC8',
        description: 'The AWS Certified Solutions Architect - Associate examination is intended for individuals who perform a solutions architect role and have one or more years of hands-on experience designing available, cost-efficient, fault-tolerant, and scalable distributed systems on AWS.',
        expiry: {
          month: Month.Jan,
          year: 2023
        },
        issued: {
          month: Month.Jan,
          year: 2018
        },
        level: CertificationLevel.Associate,
        name: 'Solutions Architect Associate',
        vendor: CertificationVendor.AWS
      },
      {
        id: 4,
        badge: null,
        credentialId: 'K591NJZ222R1QFWL',
        description: 'The AWS Certified SysOps Administrator – Associate examination is intended for systems administrators in a systems operations role with at least one year of experience in deployment, management, and operations on AWS.',
        expiry: {
          month: Month.Jul,
          year: 2023
        },
        issued: {
          month: Month.Dec,
          year: 2018
        },
        level: CertificationLevel.Associate,
        name: 'SysOps Administrator Associate',
        vendor: CertificationVendor.AWS
      },
      {
        id: 5,
        badge: null,
        credentialId: '1Q9WRMSCPFR1QLST',
        description: 'Validates expertise with designing, developing, publishing, and testing Alexa Skills',
        expiry: {
          month: Month.Dec,
          year: 2022
        },
        issued: {
          month: Month.Dec,
          year: 2019
        },
        level: CertificationLevel.Specialty,
        name: 'Alexa Skill Builder Specialty',
        vendor: CertificationVendor.AWS
      },
      {
        id: 6,
        badge: null,
        credentialId: '9GLXQ97C32QQ1699',
        description: 'Earn an industry-recognized credential from AWS that validates your expertise in the breadth of AWS database services and accelerating the use of database technology to drive your organization’s business transformation. Build credibility and confidence by highlighting your ability to design, recommend, and maintain the optimal AWS database solution for a use case.',
        expiry: {
          month: Month.Mar,
          year: 2023
        },
        issued: {
          month: Month.Jan,
          year: 2020
        },
        level: CertificationLevel.Specialty,
        name: 'Database Specialty',
        vendor: CertificationVendor.AWS
      },
      {
        id: 7,
        badge: null,
        credentialId: 'KX5PP7EKG2V11WSR',
        description: 'The AWS Certified Security – Specialty is intended for individuals who perform a security role with at least two years of hands-on experience securing AWS workloads.',
        expiry: {
          month: Month.Oct,
          year: 2022
        },
        issued: {
          month: Month.Oct,
          year: 2019
        },
        level: CertificationLevel.Specialty,
        name: 'Security Specialty',
        vendor: CertificationVendor.AWS
      },
      {
        id: 8,
        badge: null,
        credentialId: '8DJLFE6CN2441GCQ',
        description: 'Validates expertise with automating, implementing, managing, and monitoring of CI/CD systems, security controls, governance processes, compliance validation, metrics, logging systems.',
        expiry: {
          month: Month.Jul,
          year: 2023
        },
        issued: {
          month: Month.Jul,
          year: 2020
        },
        level: CertificationLevel.Professional,
        name: 'DevOps Engineer Professional',
        vendor: CertificationVendor.AWS
      },
      {
        id: 9,
        badge: null,
        credentialId: 'F9T6LYBL2BF4QC50',
        description: 'Validates expertise with designing and implementing dynamically scalable, highly available, fault-tolerant, and reliable applications',
        expiry: {
          month: Month.Dec,
          year: 2023
        },
        issued: {
          month: Month.Dec,
          year: 2020
        },
        level: CertificationLevel.Professional,
        name: 'Solutions Architect Professional',
        vendor: CertificationVendor.AWS
      },
    ];
    return of(certifications.sort((n1, n2) => {
      if (n1.level < n2.level) {
        return 1;
      }
      if (n1.level > n2.level) {
        return -1;
      }
      return 0;
    }));
  }
}
