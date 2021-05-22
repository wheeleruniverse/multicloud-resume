import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subject} from "rxjs";
import {ViewService} from "../shared/service/view.service";
import {ProjectFacade} from "../core/store/project/project.facade";
import {ProjectState} from "../core/store/project/project.state";
import {filter, takeUntil} from "rxjs/operators";

@Component({
  selector: 'app-projects',
  templateUrl: './project.component.html',
  styleUrls: [
    './project.component.scss',
    '../shared/carousel/carousel.component.scss'
  ]
})
export class ProjectComponent implements OnDestroy, OnInit {

  constructor(
    private facade: ProjectFacade,
    private viewService: ViewService
  ) {}

  destroyed$ = new Subject<void>();
  state: ProjectState;
  // targetProject: Project | null = null;
  // targetSkill: Skill | null = null;

  ngOnDestroy(): void {
    this.destroyed$.next();
    this.destroyed$.complete();
  }

  ngOnInit(): void {
    this.viewService.projectShouldEnable(false);

    this.facade.retrieve()
      .pipe(
        takeUntil(this.destroyed$),
        filter(state => !!state?.data)
      )
      .subscribe(state => {
        this.state = state;
        this.viewService.projectShouldEnable(true);
      });
  }

  // filterProject(id: number): void {
  //
  //   this.targetSkill = null;
  //
  //   if(this.targetProject != null && this.targetProject.id == id){
  //     this.targetProject = null;
  //     this.filter.setTarget('');
  //   }
  //   else {
  //     this.targetProject = this.data.find(p => p.id == id);
  //     this.filter.setTarget(`project.${id}`);
  //   }
  // }

  // filterSkill(id: number): void {
  //
  //   this.targetProject = null;
  //
  //   if(this.targetSkill != null && this.targetSkill.id == id){
  //     this.targetSkill = null;
  //     this.filter.setTarget('');
  //   }
  //   else {
  //     this.targetSkill = this.getSkill(id);
  //     this.filter.setTarget(this.targetSkill.skill);
  //   }
  // }

  // getSkill(id: number): Skill {
  //   return this.skillService.getById(id);
  // }
}
