import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {Skill, SkillDto} from "./skill.model";
import {SkillService} from "./skill.service";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {FilterService} from "../shared/filter.service";
import {MetaData} from "../shared/meta-data.model";
import {filter} from "rxjs/operators";

@Component({
  selector: 'app-skills',
  templateUrl: './skill.component.html',
  styleUrls: ['./skill.component.scss']
})
export class SkillComponent implements AfterViewInit {

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(
    private service: SkillService,
    private filter: FilterService) {}

  dto: SkillDto;
  tableFields: string[] = ['skill', 'type', 'level'];
  tableSource: MatTableDataSource<Skill>;

  ngAfterViewInit(): void {
    this.service.get().subscribe(dto => {
      this.dto = dto;
      this.tableSource = new MatTableDataSource<Skill>(dto.data);
      this.tableSource.paginator = this.paginator;
      this.tableSource.sort = this.sort;
    });

    this.filter.target$
      .pipe(filter(target => !!target))
      .subscribe(target => this.tableSource.filter = target);
  }

  getMetaForLevel(value: string): MetaData {
    return this.dto.meta.levels.find(meta => meta.name === value);
  }

  setFilter(event: Event) {
    this.filter.setTarget(event != null ? (event.target as HTMLInputElement).value : '');
  }
}
