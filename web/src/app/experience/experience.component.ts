import { Component, OnInit } from '@angular/core';
import {ExperienceService} from "./experience.service";
import {Experience} from "./experience";

@Component({
  selector: 'app-experience',
  templateUrl: './experience.component.html',
  styleUrls: ['./experience.component.css']
})
export class ExperienceComponent implements OnInit {

  constructor(private experienceService: ExperienceService) {}

  experience: Experience[] = [];

  ngOnInit(): void {
    this.getExperience();
  }

  getExperience(): void {
    this.experienceService.getExperience().subscribe(experience => this.experience = experience);
  }

}
