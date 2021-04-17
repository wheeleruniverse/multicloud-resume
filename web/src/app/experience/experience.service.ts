import { Injectable } from '@angular/core';
import {EmploymentType, Experience} from "./experience";
import {Observable, of} from "rxjs";
import {Month} from "../shared/date";

@Injectable({
  providedIn: 'root'
})
export class ExperienceService {

  constructor() { }

  getExperience(): Observable<Experience[]> {

    const experience: Experience[] = [
      {
        id: 1,
        company: 'Bravo LT',
        description: 'Work Work Work',
        end: null,
        image: null,
        location: {
          address: '40 Monroe Center St NW',
          city: 'Grand Rapids',
          state: 'Michigan',
          zip: '49503'
        },
        role: 'Senior Software Developer',
        start: {
          month: Month.Apr,
          year: 2021
        },
        type: EmploymentType.FullTime
      },
      {
        id: 2,
        company: 'Verizon',
        description: 'Work Work Work',
        end: {
          month: Month.Apr,
          year: 2021
        },
        image: null,
        location: null,
        role: 'Cloud Architect',
        start: {
          month: Month.Oct,
          year: 2020
        },
        type: EmploymentType.FullTime
      }
    ];
    return of(experience);
  }

}


