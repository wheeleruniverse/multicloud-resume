import { Component, OnInit } from '@angular/core';
import {ProjectService} from "./project.service";
import {Project} from "./project.model";
import {SkillService} from "../skill/skill.service";
import {Skill} from "../skill/skill.model";
import {FilterService} from "../shared/filter.service";

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: [
    './project.component.scss',
    '../shared/carousel.component.scss'
  ]
})
export class ProjectComponent implements OnInit {

  constructor(
    private service: ProjectService,
    private skillService: SkillService,
    private filter: FilterService) { }

  projects: Project[] = [];
  selectedSkill: Skill | null = null;

  ngOnInit(): void {
    this.service.get().subscribe(data => this.projects = data);
  }

  filterSkills(projectId: number){

    const result = this.projects.find(p => projectId == p.id);
    if(result){
      const skills = this.skillService.getByIds(result.skillIds);
    }

    console.log("result");
    console.log(result);
  }

  filterSkill(id: number): void {

    if(this.selectedSkill != null && this.selectedSkill.id == id){
      this.selectedSkill = null;
      this.filter.setCurrentSearch('');
    }

    this.selectedSkill = this.getSkill(id);
    this.filter.setCurrentSearch(this.selectedSkill.skill);
  }

  getSkill(id: number): Skill {
    return this.skillService.getById(id);
  }
}
