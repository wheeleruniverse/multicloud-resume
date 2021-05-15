import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {Skill, SkillDto} from "./skill.model";
import {SkillService} from "./skill.service";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {FilterService} from "../shared/filter.service";
import {MetaData} from "../shared/meta-data.model";

@Component({
  selector: 'app-skills',
  templateUrl: './skill.component.html',
  styleUrls: ['./skill.component.scss']
})
export class SkillComponent implements OnInit {

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  dto: SkillDto;
  tableFields: string[] = ['skill', 'type', 'level'];
  tableSource: MatTableDataSource<Skill>;

  constructor(
    private service: SkillService,
    private filter: FilterService) {}

  ngOnInit(): void {
    this.tableSource = new MatTableDataSource<Skill>([]);

    this.service.get().subscribe(dto => {
      this.dto = dto;
      this.tableSource = new MatTableDataSource<Skill>(dto.data);
      this.tableSource.paginator = this.paginator;
      this.tableSource.sort = this.sort;
    });

    this.filter.target$.subscribe(target => {
      this.tableSource.filter = target;
    });
  }

  getMetaForLevel(value: string): MetaData {
    return this.dto.meta.levels.find(meta => meta.name === value);
  }

  // getLevel(level: SkillLevel){
  //   return Object.keys(SkillLevel).find(key => SkillLevel[key] === level);
  // }

  setFilter(event: Event) {
    this.filter.setTarget(event != null ? (event.target as HTMLInputElement).value : '');
  }
}
