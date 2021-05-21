import {Component, Inject, OnDestroy, OnInit} from '@angular/core';
import {Subject} from "rxjs";
import {filter, takeUntil} from "rxjs/operators";
import {MetaData} from "../shared/model/meta-data.model";
import {CertificationState} from "../core/store/certification/certification.state";
import {CertificationFacade} from "../core/store/certification/certification.facade";
import {AppComponent, AppInjectionToken} from "../app.component";

@Component({
  selector: 'app-certifications',
  templateUrl: './certification.component.html',
  styleUrls: [
    './certification.component.scss',
    '../shared/carousel/carousel.component.scss'
  ]
})
export class CertificationComponent implements OnDestroy, OnInit {

  constructor(
    @Inject(AppInjectionToken) public app: AppComponent,
    private facade: CertificationFacade
  ) {}

  state: CertificationState;
  destroyed$ = new Subject<void>();

  ngOnDestroy(): void {
    this.destroyed$.next();
    this.destroyed$.complete();
  }

  ngOnInit(): void {
    this.app.certificationView.shouldEnable = false;

    this.facade.retrieve()
      .pipe(
        takeUntil(this.destroyed$),
        filter(state => !!state?.data)
      )
      .subscribe(state => {
        this.state = state;
        this.app.certificationView.shouldEnable = true;
      });
  }

  getMetaForLevel(value: string): MetaData {
    return this.state.meta.levels.find(meta => meta.name === value);
  }

  getMetaForVendor(value: string): MetaData {
    return this.state.meta.vendors.find(meta => meta.name === value);
  }
}
