import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs";
import {Certification} from "./certification.model";

@Injectable({
  providedIn: 'root'
})
export class CertificationService {

  constructor() { }

  getCertification(): Observable<Certification[]> {

    const certification: Certification[] = [
      {
        id: 1,
        name: 'Cloud Practitioner',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer ultrices urna diam, eget sodales urna volutpat non. Sed vulputate tortor ut molestie commodo. Praesent aliquam magna quis mauris luctus molestie. Quisque sed libero quis justo malesuada ultricies. Cras venenatis, quam in bibendum congue, leo purus lobortis nibh, sit amet varius ante arcu sed diam. Vivamus auctor ipsum in sem dignissim, quis dapibus nulla ultrices. Sed a eros sed mi condimentum facilisis.'
      },
      {
        id: 2,
        name: 'Solutions Architect Associate',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer ultrices urna diam, eget sodales urna volutpat non. Sed vulputate tortor ut molestie commodo. Praesent aliquam magna quis mauris luctus molestie. Quisque sed libero quis justo malesuada ultricies. Cras venenatis, quam in bibendum congue, leo purus lobortis nibh, sit amet varius ante arcu sed diam. Vivamus auctor ipsum in sem dignissim, quis dapibus nulla ultrices. Sed a eros sed mi condimentum facilisis.'
      }
    ];
    return of(certification);
  }
}
