import {Component, OnDestroy, OnInit} from '@angular/core';
import {CertificationService} from "./certification.service";
import {CertificationDto} from "./certification.model";
import {Subject} from "rxjs";
import {takeUntil} from "rxjs/operators";
import {MetaData} from "../shared/meta-data.model";

@Component({
  selector: 'app-certifications',
  templateUrl: './certification.component.html',
  styleUrls: [
    './certification.component.scss',
    '../shared/carousel.component.scss'
  ]
})
export class CertificationComponent implements OnDestroy, OnInit {

  constructor(private service: CertificationService) {}

  dto: CertificationDto;
  destroyed$ = new Subject<void>();

  ngOnDestroy(): void {
    this.destroyed$.next();
    this.destroyed$.complete();
  }

  ngOnInit(): void {
    this.service.get()
      .pipe(takeUntil(this.destroyed$))
      .subscribe(dto => {
        this.dto = dto;
      });
  }

  getMetaForLevel(value: string): MetaData {
    return this.dto.meta.levels.find(meta => meta.name === value);
  }

  getMetaForVendor(value: string): MetaData {
    return this.dto.meta.vendors.find(meta => meta.name === value);
  }
}
