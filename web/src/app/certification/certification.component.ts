import { Component, OnInit } from '@angular/core';
import {CertificationService} from "./certification.service";
import {Certification, CertificationLevel} from "./certification.model";

@Component({
  selector: 'app-certification',
  templateUrl: './certification.component.html',
  styleUrls: [
    './certification.component.scss',
    '../shared/carousel.component.scss'
  ]
})
export class CertificationComponent implements OnInit {

  constructor(private service: CertificationService) {}

  data: Certification[] = [];

  ngOnInit(): void {
    this.service.get().subscribe(data => this.data = data);
  }

  getLevel(level: CertificationLevel){
    return Object.keys(CertificationLevel).find(key => CertificationLevel[key] === level);
  }
}
