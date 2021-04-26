import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs";
import {EmploymentType, Experience} from "../experience/experience.model";
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
        blog: null,
        code: null,
        description: null,
        end: null,
        name: null,
        skills: [],
        start: null
      }
    ];
    return of(data);
  }
}
