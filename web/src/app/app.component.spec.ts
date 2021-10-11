import {ComponentFixture, TestBed} from '@angular/core/testing';
import {AppComponent} from './app.component';
import {CUSTOM_ELEMENTS_SCHEMA} from '@angular/core';
import {ViewFacade} from './core/store/view/view.facade';
import {BreakpointObserver, BreakpointState} from '@angular/cdk/layout';
import {IconRegistryService} from './shared/service/icon-registry.service';
import {of} from 'rxjs';
import {Dictionary} from '@ngrx/entity';
import {initialViewState, View} from './core/store/view/view.state';
import {Device} from './shared/model/device.model';
import {environment} from '../environments/environment';
import SpyObj = jasmine.SpyObj;
import {createViewDictionary} from './core/store/view/view.test-util';

describe('AppComponent', () => {
  let component: AppComponent;
  let fixture: ComponentFixture<AppComponent>;

  let breakpointObserverSpy: SpyObj<BreakpointObserver>;
  let iconRegistryServiceSpy: SpyObj<IconRegistryService>;
  let viewFacadeSpy: SpyObj<ViewFacade>;

  beforeEach(() => {
    // BreakpointObserver
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

    // IconRegistryService
    iconRegistryServiceSpy = jasmine.createSpyObj<IconRegistryService>(
      'IconRegistryService', [
        'init'
      ]
    );
    iconRegistryServiceSpy.init.and.callFake(() => {});

    // ViewFacade
    viewFacadeSpy = jasmine.createSpyObj<ViewFacade>(
      'ViewFacade', [
        'getAppView',
        'setEnable',
        'setRender',
      ]
    );
    const appView: Dictionary<View> = initialViewState.data.entities;
    viewFacadeSpy.getAppView.and.returnValue(of(appView));

    // TestBed
    TestBed.configureTestingModule({
      declarations: [AppComponent],
      providers: [
        { provide: BreakpointObserver, useValue: breakpointObserverSpy },
        { provide: IconRegistryService, useValue: iconRegistryServiceSpy },
        { provide: ViewFacade, useValue: viewFacadeSpy },
      ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    }).compileComponents();

    // Component
    fixture = TestBed.createComponent(AppComponent);
    component = fixture.componentInstance;
  });

  it('should create', () => {
    fixture.detectChanges();
    expect(component).toBeTruthy();
  });

  describe('Component', () => {
    it('Device', () => {
      expect(component.Device).toEqual(Device);
    });

    it('provider', () => {
      expect(component.provider).toEqual(environment.provider);
    });

    it('closeView', () => {
      const appView = createViewDictionary([{name: 'v1'}, {name: 'v2'}]);
      viewFacadeSpy.getAppView.and.returnValue(of(appView));
      fixture.detectChanges();

      component.closeView();

      const setRenderCalls = viewFacadeSpy.setRender.calls;
      expect(setRenderCalls.count()).toEqual(2);
      expect(setRenderCalls.argsFor(0)).toEqual(['v1', false]);
      expect(setRenderCalls.argsFor(1)).toEqual(['v2', false]);
    });

    it('toggleShouldRender with enabled matching name', () => {
      const appView = createViewDictionary([{name: 'v1'}]);
      viewFacadeSpy.getAppView.and.returnValue(of(appView));
      fixture.detectChanges();

      component.toggleShouldRender('v1');

      const setRenderCalls = viewFacadeSpy.setRender.calls;
      expect(setRenderCalls.count()).toEqual(1);
      expect(setRenderCalls.argsFor(0)).toEqual(['v1', true]);
    });

    it('toggleShouldRender with disabled matching name', () => {
      const appView = createViewDictionary([{name: 'v2', enable: false}]);
      viewFacadeSpy.getAppView.and.returnValue(of(appView));
      fixture.detectChanges();

      component.toggleShouldRender('v2');

      const setRenderCalls = viewFacadeSpy.setRender.calls;
      expect(setRenderCalls.count()).toEqual(0);
    });

    it('toggleShouldRender with non-matching name', () => {
      const appView = createViewDictionary([{name: 'v3'}]);
      viewFacadeSpy.getAppView.and.returnValue(of(appView));
      fixture.detectChanges();

      component.toggleShouldRender('v1');

      const setRenderCalls = viewFacadeSpy.setRender.calls;
      expect(setRenderCalls.count()).toEqual(0);
    });
  });

  describe('Template', () => {

  });
});
