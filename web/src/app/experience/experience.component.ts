import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { filter, takeUntil } from 'rxjs/operators';
import { ExperienceState } from '../core/store/experience/experience.state';
import { ExperienceFacade } from '../core/store/experience/experience.facade';
import { ViewFacade } from '../core/store/view/view.facade';

@Component({
  selector: 'app-experience',
  templateUrl: './experience.component.html',
  styleUrls: ['./experience.component.scss', '../shared/component/carousel/carousel.component.scss'],
})
export class ExperienceComponent implements OnDestroy, OnInit {
  constructor(private experienceFacade: ExperienceFacade, private viewFacade: ViewFacade) {}

  destroyed$ = new Subject<void>();
  state: ExperienceState;

  ngOnDestroy(): void {
    this.destroyed$.next();
    this.destroyed$.complete();
  }

  ngOnInit(): void {
    this.viewFacade.setEnable('experience', false);

    this.experienceFacade
      .retrieve()
      .pipe(
        takeUntil(this.destroyed$),
        filter((state) => !!state?.data)
      )
      .subscribe((state) => {
        this.state = state;
        this.viewFacade.setEnable('experience', true);
      });
  }
}
