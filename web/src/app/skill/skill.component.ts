import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {Skill, SkillLevel} from "./skill.model";
import {SkillService} from "./skill.service";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {FilterService} from "../shared/filter.service";

@Component({
  selector: 'app-skills',
  templateUrl: './skill.component.html',
  styleUrls: ['./skill.component.scss']
})
export class SkillComponent implements AfterViewInit, OnInit {

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  data: Skill[] = [];
  tableFields: string[] = ['skill', 'type', 'level'];
  tableSource: MatTableDataSource<Skill>;

  constructor(
    private service: SkillService,
    private filter: FilterService) {}

  ngAfterViewInit() {
    this.tableSource.paginator = this.paginator;
    this.tableSource.sort = this.sort;
  }

  ngOnInit(): void {
    this.service.get().subscribe(data => {
      this.data = data
      this.tableSource = new MatTableDataSource<Skill>(data);
    });

    this.filter.target$.subscribe(target => {
      this.tableSource.filter = target;
    });
  }

  getLevel(level: SkillLevel){
    return Object.keys(SkillLevel).find(key => SkillLevel[key] === level);
  }

  setFilter(event: Event) {
    this.filter.setTarget(event != null ? (event.target as HTMLInputElement).value : '');
  }
}
