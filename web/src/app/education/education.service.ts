import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs";
import {Education} from "./education.model";
import {Month} from "../shared/month-year.model";
import {EmploymentType} from "../experience/experience.model";

@Injectable({
  providedIn: 'root'
})
export class EducationService {

  constructor() { }

  get(): Observable<Education[]> {

    const educations: Education[] = [
      {
        id: 1,
        degree: 'Bachelor of Science',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer ultrices urna diam, eget sodales urna volutpat non. Sed vulputate tortor ut molestie commodo. Praesent aliquam magna quis mauris luctus molestie. Quisque sed libero quis justo malesuada ultricies. Cras venenatis, quam in bibendum congue, leo purus lobortis nibh, sit amet varius ante arcu sed diam. Vivamus auctor ipsum in sem dignissim, quis dapibus nulla ultrices. Sed a eros sed mi condimentum facilisis.',
        end: 2016,
        image: null,
        field: 'Game Design and Development',
        location: {
          address: '3300 University Blvd',
          city: 'Winter Park',
          remote: true,
          state: 'Florida',
          zip: '32792'
        },
        school: 'Full Sail University',
        start: 2013
      }
    ];
    return of(educations);
  }
}
