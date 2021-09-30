import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { ViewService } from '../shared/service/view.service';
import { ProjectFacade } from '../core/store/project/project.facade';
import { ProjectCompositeState } from '../core/store/project/project.state';
import { filter, takeUntil } from 'rxjs/operators';
import { FilterService } from '../shared/service/filter.service';
import { Skill } from '../core/store/skill/skill.state';
import { MatDialog } from '@angular/material/dialog';
import { ProjectDialogComponent } from './dialog/project-dialog.component';
import { BreakpointObserver } from '@angular/cdk/layout';

@Component({
  selector: 'app-projects',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.scss', '../shared/component/carousel/carousel.component.scss'],
})
export class ProjectComponent implements OnDestroy, OnInit {
  constructor(
    private breakpointObserver: BreakpointObserver,
    private dialog: MatDialog,
    private filterService: FilterService,
    private projectFacade: ProjectFacade,
    private viewService: ViewService
  ) {}

  destroyed$ = new Subject<void>();
  projectTarget: string;
  state: ProjectCompositeState;
  skillLimit = 20;
  skillShouldRender: boolean;
  skillSortBy = 'Name';
  skillTarget: string;

  ngOnDestroy(): void {
    this.destroyed$.next();
    this.destroyed$.complete();
  }

  ngOnInit(): void {
    this.breakpointObserver
      .observe('(max-width: 425px)')
      .pipe(filter((result) => result.matches))
      .subscribe(() => {
        this.skillLimit = 5;
      });

    this.viewService.projectShouldEnable(false);
    this.projectFacade
      .retrieve()
      .pipe(
        takeUntil(this.destroyed$),
        filter((state) => !!state?.projects)
      )
      .subscribe((state) => {
        this.state = state;
        this.viewService.projectShouldEnable(true);
      });

    this.viewService.skillShouldRender$.subscribe((val) => {
      this.skillShouldRender = val;
    });
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(ProjectDialogComponent);
    dialogRef.afterClosed().subscribe(() => {});
  }

  getSkills(ids: string[]): Skill[] {
    return !!this.state?.skills ? this.state.skills.filter((skill) => ids.includes(skill.id)) : [];
  }

  getSkillNames(ids: string[]): string[] {
    return this.getSkills(ids)
      .map((skill) => skill.name)
      .filter((value, index, self) => self.indexOf(value) === index)
      .sort((n1, n2) => (n1 === n2 ? 0 : n1 > n2 ? 1 : -1) * 1)
      .slice(0, this.skillLimit);
  }

  getSkillTypes(ids: string[]): string[] {
    return this.getSkills(ids)
      .map((skill) => skill.type)
      .filter((value, index, self) => self.indexOf(value) === index)
      .sort((n1, n2) => (n1 === n2 ? 0 : n1 > n2 ? 1 : -1) * 1)
      .slice(0, this.skillLimit);
  }

  renderSkillView(): void {
    if (!this.skillShouldRender) {
      this.viewService.skillShouldRender(true);
    }
  }

  setProjectFilter(value: string): void {
    this.renderSkillView();
    this.skillTarget = null;

    if (!this.skillShouldRender) {
      this.viewService.skillShouldRender(true);
    }
    if (this.projectTarget === value) {
      this.projectTarget = null;
      this.filterService.setTarget('');
      return;
    }
    this.projectTarget = value;
    this.filterService.setTarget(value);
  }

  setSkillFilter(value: string): void {
    this.renderSkillView();
    this.projectTarget = null;

    if (this.skillTarget === value) {
      this.skillTarget = null;
      this.filterService.setTarget('');
      return;
    }
    this.skillTarget = value;
    this.filterService.setTarget(value);
  }

  setSkillSortBy(sortBy: string): void {
    this.skillSortBy = sortBy;
  }
}
