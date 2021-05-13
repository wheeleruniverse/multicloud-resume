import { Injectable } from '@angular/core';
import {EmploymentType, Experience} from "./experience.model";
import {Observable, of} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ExperienceService {

  constructor() { }

  get(): Observable<Experience[]> {

    const data: Experience[] = [
      {
        id: 1,
        name: 'Bravo LT',
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
          remote: true,
          state: 'Michigan',
          zip: '49503'
        },
        project: 'Gordon Ordering',
        role: 'Senior Software Developer',
        start: {
          month: 4,
          year: 2021
        },
        type: EmploymentType.FullTime
      },
      {
        id: 2,
        name: 'Verizon 1',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer ultrices urna diam, eget sodales urna volutpat non. Sed vulputate tortor ut molestie commodo. Praesent aliquam magna quis mauris luctus molestie. Quisque sed libero quis justo malesuada ultricies. Cras venenatis, quam in bibendum congue, leo purus lobortis nibh, sit amet varius ante arcu sed diam. Vivamus auctor ipsum in sem dignissim, quis dapibus nulla ultrices. Sed a eros sed mi condimentum facilisis.',
        end: {
          month: 4,
          year: 2021
        },
        image: {
          alt: 'Verizon Logo',
          height: null,
          name: 'Verizon Logo',
          src: 'assets/experience/verizon-logo.jpg',
          width: null
        },
        location: {
          address: '7701 E Telecom Pkwy',
          city: 'Temple Terrace',
          remote: true,
          state: 'Florida',
          zip: '33637'
        },
        project: 'Network Planning Platform',
        role: 'Cloud Architect',
        start: {
          month: 10,
          year: 2020
        },
        type: EmploymentType.FullTime
      },
      {
        id: 3,
        name: 'Verizon 2',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer ultrices urna diam, eget sodales urna volutpat non. Sed vulputate tortor ut molestie commodo. Praesent aliquam magna quis mauris luctus molestie. Quisque sed libero quis justo malesuada ultricies. Cras venenatis, quam in bibendum congue, leo purus lobortis nibh, sit amet varius ante arcu sed diam. Vivamus auctor ipsum in sem dignissim, quis dapibus nulla ultrices. Sed a eros sed mi condimentum facilisis.',
        end: {
          month: 4,
          year: 2021
        },
        image: {
          alt: 'Verizon Logo',
          height: null,
          name: 'Verizon Logo',
          src: 'assets/experience/verizon-logo.jpg',
          width: null
        },
        location: {
          address: '7701 E Telecom Pkwy',
          city: 'Temple Terrace',
          remote: false,
          state: 'Florida',
          zip: '33637'
        },
        project: 'Network Planning Platform',
        role: 'Cloud Architect',
        start: {
          month: 10,
          year: 2020
        },
        type: EmploymentType.FullTime
      },
      {
        id: 4,
        name: 'Verizon 3',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer ultrices urna diam, eget sodales urna volutpat non. Sed vulputate tortor ut molestie commodo. Praesent aliquam magna quis mauris luctus molestie. Quisque sed libero quis justo malesuada ultricies. Cras venenatis, quam in bibendum congue, leo purus lobortis nibh, sit amet varius ante arcu sed diam. Vivamus auctor ipsum in sem dignissim, quis dapibus nulla ultrices. Sed a eros sed mi condimentum facilisis.',
        end: {
          month: 4,
          year: 2021
        },
        image: {
          alt: 'Verizon Logo',
          height: null,
          name: 'Verizon Logo',
          src: 'assets/experience/verizon-logo.jpg',
          width: null
        },
        location: {
          address: '7701 E Telecom Pkwy',
          city: 'Temple Terrace',
          remote: false,
          state: 'Florida',
          zip: '33637'
        },
        project: 'Network Planning Platform',
        role: 'Cloud Architect',
        start: {
          month: 10,
          year: 2020
        },
        type: EmploymentType.FullTime
      }
    ];
    return of(data);
  }
}


