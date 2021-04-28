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
export class SkillComponent implements OnInit, AfterViewInit {

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  displayedColumns: string[] = ['skill', 'type', 'level'];
  dataSource: MatTableDataSource<Skill>;
  skills: Skill[] = [];

  constructor(private service: SkillService, private filter: FilterService) { }

  ngOnInit(): void {
    this.service.get().subscribe(data => {
      this.dataSource = new MatTableDataSource<Skill>(data);
      this.skills = data
    });

    this.filter.currentSearch$.subscribe(
      searchTerm => {
        console.log("searchTerm: ", searchTerm);
        this.dataSource.filter = searchTerm;
      },
      error => {
        console.log("error: ", error);
      },
      () => {
        console.log("complete!");
      }
    );
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  setFilter(event: Event) {
    const value = (event.target as HTMLInputElement).value;
    this.filter.setCurrentSearch(value);
  }

  getLevel(level: SkillLevel){
    return Object.keys(SkillLevel).find(key => SkillLevel[key] === level);
  }
}
