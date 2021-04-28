import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs";
import {Month} from "../shared/month-year.model";
import {Project} from "./project.model";

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor() { }

  get(): Observable<Project[]> {

    const data: Project[] = [
      {
        id: 1,
        blog: 'https://dev.to/wheelerswebsites/my-september-cloud-guru-challenge-experience-l2j',
        code: 'https://github.com/wheelers-websites/CloudGuruChallenge_20.09',
        description: 'Automate an ETL processing pipeline for COVID-19 data using Python and cloud services.',
        end: {
          month: Month.Sep,
          year: 2020
        },
        name: '#CloudGuruChallenge Sep, 20',
        skillIds: [3, 7, 20, 21, 22, 23],
        start: {
          month: Month.Sep,
          year: 2020
        }
      }
    ];
    return of(data);
  }
}
