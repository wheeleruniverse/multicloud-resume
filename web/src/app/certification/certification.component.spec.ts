import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CertificationComponent } from './certification.component';
import { CertificationFacade } from '../core/store/certification/certification.facade';
import { of } from 'rxjs';
import { CertificationState } from '../core/store/certification/certification.state';
import { MonthYearPipe } from '../shared/pipe/month-year.pipe';
import SpyObj = jasmine.SpyObj;
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import {ViewFacade} from '../core/store/view/view.facade';

describe('CertificationsComponent', () => {
  let component: CertificationComponent;
  let fixture: ComponentFixture<CertificationComponent>;
  let certificationFacadeSpy: SpyObj<CertificationFacade>;
  let viewFacadeSpy: SpyObj<ViewFacade>;

  beforeEach(async () => {
    certificationFacadeSpy = jasmine.createSpyObj<CertificationFacade>(
      'CertificationFacade', ['retrieve']
    );
    viewFacadeSpy = jasmine.createSpyObj<ViewFacade>(
      'ViewFacade', ['setEnable']
    );

    const state: CertificationState = {
      data: [
        {
          id: 'testId',
          name: 'testName',
          credential: 'testCredential',
          descriptions: ['testDescription'],
          expiry: {
            year: 2021,
            month: 5,
          },
          issued: {
            year: 2020,
            month: 5,
          },
          level: 'testLevel',
          vendor: 'testVendor',
        },
      ],
      meta: {
        levels: [
          {
            name: 'testLevel',
            display: 'levelDisplay',
            description: 'levelDescription',
            rank: 0,
          },
        ],
        vendors: [
          {
            name: 'testVendor',
            display: 'vendorDisplay',
          },
        ],
      },
    };
    certificationFacadeSpy.retrieve.and.returnValue(of(state));

    await TestBed.configureTestingModule({
      declarations: [CertificationComponent, MonthYearPipe],
      providers: [
        { provide: CertificationFacade, useValue: certificationFacadeSpy },
        { provide: ViewFacade, useValue: viewFacadeSpy },
      ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    }).compileComponents();
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
