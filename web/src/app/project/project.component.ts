import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subject} from "rxjs";
import {ViewService} from "../shared/service/view.service";
import {ProjectFacade} from "../core/store/project/project.facade";
import {ProjectState} from "../core/store/project/project.state";
import {filter, takeUntil} from "rxjs/operators";
import {FilterService} from "../shared/service/filter.service";

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
    private filterService: FilterService,
    private viewService: ViewService
  ) {}

  destroyed$ = new Subject<void>();
  state: ProjectState;
  targetSkill = '';

  // targetProject: Project | null = null;

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

  setFilterToSkill(skill: string): void {

    // render skill
    // TODO: Filter not being applied after Skill is rendered perhaps
    // TODO: subscribe to if it is rendered and base logic on that value
    this.viewService.skillShouldRender(true);

    // unselect if already selected
    if(this.targetSkill === skill){
      this.targetSkill = null;
      this.filterService.setTarget('');
      return;
    }

    // select if not unselected
    this.targetSkill = skill;
    this.filterService.setTarget(this.targetSkill);
  }
}
