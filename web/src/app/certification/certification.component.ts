import {ChangeDetectionStrategy, ChangeDetectorRef, Component, OnDestroy, OnInit} from '@angular/core';
import {CertificationService} from "./certification.service";
import {Certification, CertificationLevel} from "./certification.model";
import {Observable, Subject} from "rxjs";
import {takeUntil} from "rxjs/operators";

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

  data: Certification[];
  destroyed$ = new Subject<void>();

  ngOnDestroy(): void {
    this.destroyed$.next();
    this.destroyed$.complete();
  }

  ngOnInit(): void {
    this.service.get()
      .pipe(takeUntil(this.destroyed$))
      .subscribe(data => {
        this.data = data;
      });
  }

  getLevelValue(level: string){
    switch(level){
      case "ASSOCIATE": return 2;
      case "FOUNDATIONAL": return 1;
      case "PROFESSIONAL": return 4;
      case "SPECIALTY": return 3;
      default: return 0;
    }
  }
}
