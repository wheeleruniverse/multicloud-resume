import { Injectable } from '@angular/core';
import {EmploymentType, Experience} from "./experience";
import {Observable, of} from "rxjs";
import {Month} from "../shared/models/month-year";

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
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer ultrices urna diam, eget sodales urna volutpat non. Sed vulputate tortor ut molestie commodo. Praesent aliquam magna quis mauris luctus molestie. Quisque sed libero quis justo malesuada ultricies. Cras venenatis, quam in bibendum congue, leo purus lobortis nibh, sit amet varius ante arcu sed diam. Vivamus auctor ipsum in sem dignissim, quis dapibus nulla ultrices. Sed a eros sed mi condimentum facilisis.',
        end: null,
        image: {
          alt: 'Bravo LT Logo',
          height: null,
          name: 'Bravo LT Logo',
          src: 'assets/experience/bravo-logo.png',
          width: null
        },
        location: {
          address: '40 Monroe Center St NW',
          city: 'Grand Rapids',
          state: 'Michigan',
          zip: '49503'
        },
        project: 'Gordon Ordering',
        role: 'Senior Software Developer',
        start: {
          month: Month.Apr,
          year: 2021
        },
        type: EmploymentType.FullTime
      },
      {
        id: 2,
        company: 'Verizon 1',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer ultrices urna diam, eget sodales urna volutpat non. Sed vulputate tortor ut molestie commodo. Praesent aliquam magna quis mauris luctus molestie. Quisque sed libero quis justo malesuada ultricies. Cras venenatis, quam in bibendum congue, leo purus lobortis nibh, sit amet varius ante arcu sed diam. Vivamus auctor ipsum in sem dignissim, quis dapibus nulla ultrices. Sed a eros sed mi condimentum facilisis.',
        end: {
          month: Month.Apr,
          year: 2021
        },
        image: {
          alt: 'Verizon Logo',
          height: null,
          name: 'Verizon Logo',
          src: 'assets/experience/verizon-logo.jpg',
          width: null
        },
        location: null,
        project: 'Network Planning Platform',
        role: 'Cloud Architect',
        start: {
          month: Month.Oct,
          year: 2020
        },
        type: EmploymentType.FullTime
      },
      {
        id: 3,
        company: 'Verizon 2',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer ultrices urna diam, eget sodales urna volutpat non. Sed vulputate tortor ut molestie commodo. Praesent aliquam magna quis mauris luctus molestie. Quisque sed libero quis justo malesuada ultricies. Cras venenatis, quam in bibendum congue, leo purus lobortis nibh, sit amet varius ante arcu sed diam. Vivamus auctor ipsum in sem dignissim, quis dapibus nulla ultrices. Sed a eros sed mi condimentum facilisis.',
        end: {
          month: Month.Apr,
          year: 2021
        },
        image: {
          alt: 'Verizon Logo',
          height: null,
          name: 'Verizon Logo',
          src: 'assets/experience/verizon-logo.jpg',
          width: null
        },
        location: null,
        project: 'Network Planning Platform',
        role: 'Cloud Architect',
        start: {
          month: Month.Oct,
          year: 2020
        },
        type: EmploymentType.FullTime
      },
      {
        id: 4,
        company: 'Verizon 3',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer ultrices urna diam, eget sodales urna volutpat non. Sed vulputate tortor ut molestie commodo. Praesent aliquam magna quis mauris luctus molestie. Quisque sed libero quis justo malesuada ultricies. Cras venenatis, quam in bibendum congue, leo purus lobortis nibh, sit amet varius ante arcu sed diam. Vivamus auctor ipsum in sem dignissim, quis dapibus nulla ultrices. Sed a eros sed mi condimentum facilisis.',
        end: {
          month: Month.Apr,
          year: 2021
        },
        image: {
          alt: 'Verizon Logo',
          height: null,
          name: 'Verizon Logo',
          src: 'assets/experience/verizon-logo.jpg',
          width: null
        },
        location: null,
        project: 'Network Planning Platform',
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


