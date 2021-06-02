import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EducationComponent } from './education.component';
import { ViewService } from '../shared/service/view.service';
import { of } from 'rxjs';
import { EducationFacade } from '../core/store/education/education.facade';
import { EducationState } from '../core/store/education/education.state';
import SpyObj = jasmine.SpyObj;
import { LocationPipe } from '../shared/pipe/location.pipe';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

describe('EducationComponent', () => {
  let component: EducationComponent;
  let fixture: ComponentFixture<EducationComponent>;
  let facadeSpy: SpyObj<EducationFacade>;
  let viewServiceSpy: SpyObj<ViewService>;

  beforeEach(async () => {
    facadeSpy = jasmine.createSpyObj<EducationFacade>('EducationFacade', ['retrieve']);

    viewServiceSpy = jasmine.createSpyObj<ViewService>('ViewService', [
      'educationShouldEnable',
      'educationShouldRender',
    ]);

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
    facadeSpy.retrieve.and.returnValue(of(state));

    await TestBed.configureTestingModule({
      declarations: [EducationComponent, LocationPipe],
      providers: [
        { provide: EducationFacade, useValue: facadeSpy },
        { provide: ViewService, useValue: viewServiceSpy },
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
