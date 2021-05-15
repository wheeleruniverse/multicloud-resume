import {Component, OnDestroy, OnInit} from '@angular/core';
import {ProjectService} from "./project.service";
import {Project} from "./project.model";
import {SkillService} from "../skill/skill.service";
import {Skill} from "../skill/skill.model";
import {FilterService} from "../shared/filter.service";
import {Subject} from "rxjs";

@Component({
  selector: 'app-projects',
  templateUrl: './project.component.html',
  styleUrls: [
    './project.component.scss',
    '../shared/carousel.component.scss'
  ]
})
export class ProjectComponent implements OnDestroy, OnInit {

  constructor(
    private service: ProjectService,
    private filter: FilterService,
    private skillService: SkillService) {}

  data: Project[];
  destroyed$ = new Subject<void>();
  targetProject: Project | null = null;
  targetSkill: Skill | null = null;


  ngOnDestroy(): void {
    this.destroyed$.next();
    this.destroyed$.complete();
  }

  ngOnInit(): void {
    this.service.get().subscribe(data => this.data = data);
  }

  filterProject(id: number): void {

    this.targetSkill = null;

    if(this.targetProject != null && this.targetProject.id == id){
      this.targetProject = null;
      this.filter.setTarget('');
    }
    else {
      this.targetProject = this.data.find(p => p.id == id);
      this.filter.setTarget(`project.${id}`);
    }
  }

  filterSkill(id: number): void {

    this.targetProject = null;

    if(this.targetSkill != null && this.targetSkill.id == id){
      this.targetSkill = null;
      this.filter.setTarget('');
    }
    else {
      // this.targetSkill = this.getSkill(id);
      // this.filter.setTarget(this.targetSkill.skill);
    }
  }

  // getSkill(id: number): Skill {
  //   return this.skillService.getById(id);
  // }
}
