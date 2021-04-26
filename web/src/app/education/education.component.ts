import { Component, OnInit } from '@angular/core';
import {Education} from "./education.model";
import {EducationService} from "./education.service";


@Component({
  selector: 'app-education',
  templateUrl: './education.component.html',
  styleUrls: [
    './education.component.scss',
    '../shared/carousel.component.scss'
  ]
})
export class EducationComponent implements OnInit {

  constructor(private service: EducationService) {}

  educations: Education[] = [];

  ngOnInit(): void {
    this.service.get().subscribe(data => this.educations = data);
  }
}
