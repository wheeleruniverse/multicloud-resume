import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subject} from 'rxjs';
import {filter, takeUntil} from 'rxjs/operators';
import {EducationState} from '../core/store/education/education.state';
import {EducationFacade} from '../core/store/education/education.facade';
import {ViewFacade} from '../core/store/view/view.facade';

@Component({
  selector: 'app-education',
  templateUrl: './education.component.html',
  styleUrls: ['./education.component.scss', '../shared/component/carousel/carousel.component.scss'],
})
export class EducationComponent implements OnDestroy, OnInit {
  constructor(private educationFacade: EducationFacade, private viewFacade: ViewFacade) {}

  destroyed$ = new Subject<void>();
  state: EducationState;

  ngOnDestroy(): void {
    this.destroyed$.next();
    this.destroyed$.complete();
  }

  ngOnInit(): void {
    this.viewFacade.setEnable('education', false);

    this.educationFacade
      .retrieve()
      .pipe(
        takeUntil(this.destroyed$),
        filter((state) => !!state?.data)
      )
      .subscribe((state) => {
        this.state = state;
        this.viewFacade.setEnable('education', true);
      });
  }
}
