import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EducationComponent } from './education.component';
import { of } from 'rxjs';
import { EducationFacade } from '../core/store/education/education.facade';
import { EducationState } from '../core/store/education/education.state';
import SpyObj = jasmine.SpyObj;
import { LocationPipe } from '../shared/pipe/location.pipe';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import {ViewFacade} from '../core/store/view/view.facade';

describe('EducationComponent', () => {
  let component: EducationComponent;
  let fixture: ComponentFixture<EducationComponent>;
  let educationFacadeSpy: SpyObj<EducationFacade>;
  let viewFacadeSpy: SpyObj<ViewFacade>;

  beforeEach(async () => {
    educationFacadeSpy = jasmine.createSpyObj<EducationFacade>(
      'EducationFacade', ['retrieve']
    );
    viewFacadeSpy = jasmine.createSpyObj<ViewFacade>(
      'ViewFacade', ['setEnable']
    );

    const state: EducationState = {
      data: [
        {
          id: 'testId',
          name: 'testName',
          degree: 'testDegree',
          descriptions: [],
          end: 2021,
          image: undefined,
          field: 'testField',
          location: {
            address: 'testAddress',
            city: 'testCity',
            remote: true,
            state: 'testState',
            zip: 'testZip',
          },
          start: 2020,
        },
      ],
    };
    educationFacadeSpy.retrieve.and.returnValue(of(state));

    await TestBed.configureTestingModule({
      declarations: [EducationComponent, LocationPipe],
      providers: [
        { provide: EducationFacade, useValue: educationFacadeSpy },
        { provide: ViewFacade, useValue: viewFacadeSpy },
      ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EducationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
