import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subject} from 'rxjs';
import {filter, takeUntil} from 'rxjs/operators';
import {EducationState} from '../core/store/education/education.state';
import {ViewService} from '../shared/service/view.service';
import {EducationFacade} from '../core/store/education/education.facade';

@Component({
  selector: 'app-education',
  templateUrl: './education.component.html',
  styleUrls: ['./education.component.scss', '../shared/carousel/carousel.component.scss'],
})
export class EducationComponent implements OnDestroy, OnInit {
  constructor(private facade: EducationFacade, private viewService: ViewService) {}

  destroyed$ = new Subject<void>();
  state: EducationState;

  ngOnDestroy(): void {
    this.destroyed$.next();
    this.destroyed$.complete();
  }

  ngOnInit(): void {
    this.viewService.educationShouldEnable(false);

    this.facade
      .retrieve()
      .pipe(
        takeUntil(this.destroyed$),
        filter((state) => !!state?.data)
      )
      .subscribe((state) => {
        this.state = state;
        this.viewService.educationShouldEnable(true);
      });
  }
}
