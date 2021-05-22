import {Component, OnDestroy, OnInit} from '@angular/core';
import {ExperienceService} from "../core/service/experience/experience.service";
import {Experience} from "./experience.model";
import {Subject} from "rxjs";
import {takeUntil} from "rxjs/operators";

@Component({
  selector: 'app-experience',
  templateUrl: './experience.component.html',
  styleUrls: [
    './experience.component.scss',
    '../shared/carousel/carousel.component.scss'
  ]
})
export class ExperienceComponent implements OnDestroy, OnInit {

  constructor(private service: ExperienceService) {}

  data: Experience[];
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
