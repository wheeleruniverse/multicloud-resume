import {Component, OnDestroy, OnInit} from '@angular/core';
import {Education} from "./education.model";
import {EducationService} from "./education.service";
import {Subject} from "rxjs";
import {takeUntil} from "rxjs/operators";


@Component({
  selector: 'app-education',
  templateUrl: './education.component.html',
  styleUrls: [
    './education.component.scss',
    '../shared/carousel/carousel.component.scss'
  ]
})
export class EducationComponent implements OnDestroy, OnInit {

  constructor(private service: EducationService) {}

  data: Education[];
  destroyed$ = new Subject<void>();

  ngOnDestroy(): void {
    this.destroyed$.next();
    this.destroyed$.complete();
  }

  ngOnInit(): void {
    this.service.get()
      .pipe(takeUntil(this.destroyed$))
      .subscribe(data => this.data = data);
  }
}
