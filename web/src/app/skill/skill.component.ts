import {AfterViewInit, Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {FilterService} from "../shared/service/filter.service";
import {MetaData} from "../shared/model/meta-data.model";
import {filter, takeUntil} from "rxjs/operators";
import {Skill, SkillState} from "../core/store/skill/skill.state";
import {ViewService} from "../shared/service/view.service";
import {SkillFacade} from "../core/store/skill/skill.facade";
import {Subject} from "rxjs";

@Component({
  selector: 'app-skills',
  templateUrl: './skill.component.html',
  styleUrls: ['./skill.component.scss']
})
export class SkillComponent implements AfterViewInit, OnDestroy {

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(
    private facade: SkillFacade,
    private filterService: FilterService,
    private viewService: ViewService
  ) {}

  destroyed$ = new Subject<void>();
  state: SkillState;
  tableFields: string[] = ['skill', 'type', 'level'];
  tableSource: MatTableDataSource<Skill>;

  ngAfterViewInit(): void {
    this.viewService.skillShouldEnable(false);

    this.facade.retrieve()
      .pipe(
        takeUntil(this.destroyed$),
        filter(state => !!state?.data)
      )
      .subscribe(state => {
        this.state = state;
        this.tableSource = new MatTableDataSource<Skill>(state.data);
        this.tableSource.paginator = this.paginator;
        this.tableSource.sort = this.sort;
        this.viewService.skillShouldEnable(true);
      });

    this.filterService.target$.subscribe(target => {
      if(!!this.tableSource) {
        this.tableSource.filter = target;
      }
    });
  }

  ngOnDestroy(): void {
    this.destroyed$.next();
    this.destroyed$.complete();
  }

  getMetaForLevel(value: string): MetaData {
    return this.state.meta.levels.find(meta => meta.name === value);
  }

  setFilter(event: Event) {
    this.filterService.setTarget(event != null ? (event.target as HTMLInputElement).value : '');
  }
}
