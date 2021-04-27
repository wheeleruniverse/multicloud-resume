import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {Skill, SkillLevel} from "./skill.model";
import {SkillService} from "./skill.service";
import {MatPaginator} from "@angular/material/paginator";
import {CertificationLevel} from "../certification/certification.model";
import {MatSort} from "@angular/material/sort";

@Component({
  selector: 'app-skills',
  templateUrl: './skill.component.html',
  styleUrls: ['./skill.component.scss']
})
export class SkillComponent implements OnInit, AfterViewInit {

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  displayedColumns: string[] = ['skill', 'type', 'level'];
  dataSource: MatTableDataSource<Skill>;
  skills: Skill[] = [];

  constructor(private service: SkillService) { }

  ngOnInit(): void {
    this.service.get().subscribe(data => {
      this.dataSource = new MatTableDataSource<Skill>(data);
      this.skills = data
    });
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  setFilter(event: Event) {
    const value = (event.target as HTMLInputElement).value;
    this.dataSource.filter = value.trim().toLowerCase();
  }

  getLevel(level: SkillLevel){
    return Object.keys(SkillLevel).find(key => SkillLevel[key] === level);
  }
}
