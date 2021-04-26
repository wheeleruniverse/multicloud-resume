import { Component, OnInit } from '@angular/core';
import {ProjectService} from "./project.service";
import {Project} from "./project.model";

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: [
    './project.component.scss',
    '../shared/carousel.component.scss'
  ]
})
export class ProjectComponent implements OnInit {

  constructor(private service: ProjectService) { }

  projects: Project[] = [];

  ngOnInit(): void {
    this.service.get().subscribe(data => this.projects = data);
  }
}
