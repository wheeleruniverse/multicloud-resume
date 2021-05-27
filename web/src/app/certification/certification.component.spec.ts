import {ComponentFixture, TestBed} from '@angular/core/testing';

import {CertificationComponent} from './certification.component';
import {CertificationFacade} from "../core/store/certification/certification.facade";
import {ViewService} from "../shared/service/view.service";
import {of} from "rxjs";
import {CertificationState} from "../core/store/certification/certification.state";
import {MonthYearPipe} from "../shared/pipe/month-year.pipe";
import SpyObj = jasmine.SpyObj;

describe('CertificationsComponent', () => {
  let component: CertificationComponent;
  let fixture: ComponentFixture<CertificationComponent>;
  let facadeSpy: SpyObj<CertificationFacade>;
  let viewServiceSpy: SpyObj<ViewService>;

  beforeEach(async () => {

    facadeSpy = jasmine.createSpyObj<CertificationFacade>(
      'CertificationFacade', [
        'retrieve'
      ]);

    viewServiceSpy = jasmine.createSpyObj<ViewService>(
      'ViewService', [
        'certificationShouldEnable', 'certificationShouldRender'
      ]);

    const state: CertificationState = {
      data: [{
        id: 'testId',
        name: 'testName',
        credential: 'testCredential',
        description: 'testDescription',
        expiry: {
          year: 2021,
          month: 5
        },
        issued: {
          year: 2020,
          month: 5
        },
        level: 'testLevel',
        vendor: 'testVendor'
      }],
      meta: {
        levels: [{
          name: 'testLevel',
          display: 'levelDisplay',
          description: 'levelDescription',
          rank: 0
        }],
        vendors:  [{
          name: 'testVendor',
          display: 'vendorDisplay'
        }]
      }
    }
    facadeSpy.retrieve.and.returnValue(of(state));

    await TestBed.configureTestingModule({
      declarations: [
        CertificationComponent,
        MonthYearPipe
      ],
      providers: [
        {provide: CertificationFacade, useValue: facadeSpy},
        {provide: ViewService, useValue: viewServiceSpy}
      ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CertificationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
