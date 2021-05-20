import {Component, OnDestroy, OnInit} from '@angular/core';
import {CertificationService} from "../core/service/certification/certification.service";
import {Subject} from "rxjs";
import {takeUntil} from "rxjs/operators";
import {MetaData} from "../shared/model/meta-data.model";
import {CertificationState} from "../core/store/certification/certification.state";
import {CertificationFacade} from "../core/store/certification/certification.facade";

@Component({
  selector: 'app-certifications',
  templateUrl: './certification.component.html',
  styleUrls: [
    './certification.component.scss',
    '../shared/carousel/carousel.component.scss'
  ]
})
export class CertificationComponent implements OnDestroy, OnInit {

  constructor(private facade: CertificationFacade) {}

  state: CertificationState;
  destroyed$ = new Subject<void>();

  ngOnDestroy(): void {
    this.destroyed$.next();
    this.destroyed$.complete();
  }

  ngOnInit(): void {
    this.facade.retrieve()
      .pipe(takeUntil(this.destroyed$))
      .subscribe(state => this.state = state);
  }

  getMetaForLevel(value: string): MetaData {
    return this.state.meta.levels.find(meta => meta.name === value);
  }

  getMetaForVendor(value: string): MetaData {
    return this.state.meta.vendors.find(meta => meta.name === value);
  }
}
