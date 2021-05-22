import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subject} from "rxjs";
import {filter, takeUntil} from "rxjs/operators";
import {ExperienceState} from "../core/store/experience/experience.state";
import {ViewService} from "../shared/service/view.service";
import {ExperienceFacade} from "../core/store/experience/experience.facade";

@Component({
  selector: 'app-experience',
  templateUrl: './experience.component.html',
  styleUrls: [
    './experience.component.scss',
    '../shared/carousel/carousel.component.scss'
  ]
})
export class ExperienceComponent implements OnDestroy, OnInit {

  constructor(
    private facade: ExperienceFacade,
    private viewService: ViewService
  ) {}

  destroyed$ = new Subject<void>();
  state: ExperienceState;

  ngOnDestroy(): void {
    this.destroyed$.next();
    this.destroyed$.complete();
  }

  ngOnInit(): void {
    this.viewService.experienceShouldEnable(false);

    this.facade.retrieve()
      .pipe(
        takeUntil(this.destroyed$),
        filter(state => !!state?.data)
      )
      .subscribe(state => {
        this.state = state;
        this.viewService.experienceShouldEnable(true);
      });
  }
}
