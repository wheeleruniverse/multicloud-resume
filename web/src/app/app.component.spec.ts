import {ComponentFixture, TestBed} from '@angular/core/testing';
import { AppComponent } from './app.component';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import {ViewFacade} from './core/store/view/view.facade';
import SpyObj = jasmine.SpyObj;
import {BreakpointObserver, BreakpointState} from '@angular/cdk/layout';
import {IconRegistryService} from './shared/service/icon-registry.service';
import {of} from 'rxjs';
import {Dictionary} from '@ngrx/entity';
import {initialViewState, View} from './core/store/view/view.state';

describe('AppComponent', () => {
  let component: AppComponent;
  let fixture: ComponentFixture<AppComponent>;

  let breakpointObserverSpy: SpyObj<BreakpointObserver>;
  let iconRegistryServiceSpy: SpyObj<IconRegistryService>;
  let viewFacadeSpy: SpyObj<ViewFacade>;

  beforeEach(async () => {
    breakpointObserverSpy = jasmine.createSpyObj<BreakpointObserver>(
      'BreakpointObserver', [
        'observe'
      ]
    );
    const breakpoint: BreakpointState = {
      breakpoints: {
        '(max-width: 425px)': true,
        '(max-width: 768px)': true
      },
      matches: true
    };
    breakpointObserverSpy.observe.and.returnValue(of(breakpoint));

    iconRegistryServiceSpy = jasmine.createSpyObj<IconRegistryService>(
      'IconRegistryService', [
        'init'
      ]
    );
    iconRegistryServiceSpy.init.and.callFake(() => {});

    viewFacadeSpy = jasmine.createSpyObj<ViewFacade>(
      'ViewFacade', [
        'getAppView',
        'setEnable'
      ]
    );
    const appView: Dictionary<View> = initialViewState.data.entities;
    viewFacadeSpy.getAppView.and.returnValue(of(appView));

    await TestBed.configureTestingModule({
      declarations: [AppComponent],
      providers: [
        { provide: ViewFacade, useValue: viewFacadeSpy },
      ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
