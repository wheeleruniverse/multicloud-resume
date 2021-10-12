import {ComponentFixture, TestBed} from '@angular/core/testing';
import {AppComponent} from './app.component';
import {CUSTOM_ELEMENTS_SCHEMA, DebugElement} from '@angular/core';
import {ViewFacade} from './core/store/view/view.facade';
import {BreakpointObserver, BreakpointState} from '@angular/cdk/layout';
import {IconRegistryService} from './shared/service/icon-registry.service';
import {of} from 'rxjs';
import {Dictionary} from '@ngrx/entity';
import {initialViewState, View} from './core/store/view/view.state';
import {Device} from './shared/model/device.model';
import {environment} from '../environments/environment';
import SpyObj = jasmine.SpyObj;
import {createView, createViewDictionary} from './core/store/view/view.test-util';
import {By} from '@angular/platform-browser';

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
    mockBreakpointObserver(Device.Desktop);

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
    it('should closeView trigger viewFacade#setRender', () => {
      const appView = createViewDictionary([{name: 'v1'}, {name: 'v2'}]);
      viewFacadeSpy.getAppView.and.returnValue(of(appView));
      fixture.detectChanges();

      component.closeView();

      const setRenderCalls = viewFacadeSpy.setRender.calls;
      expect(setRenderCalls.count()).toEqual(2);
      expect(setRenderCalls.argsFor(0)).toEqual(['v1', false]);
      expect(setRenderCalls.argsFor(1)).toEqual(['v2', false]);
    });

    it('should Device match the Device enum', () => {
      expect(component.Device).toEqual(Device);
    });

    it('should provider return environment.provider', () => {
      expect(component.provider).toEqual(environment.provider);
    });

    it('should toggleShouldRender not trigger viewFacade#setRender with disabled matching view', () => {
      const appView = createViewDictionary([{name: 'v2', enable: false}]);
      viewFacadeSpy.getAppView.and.returnValue(of(appView));
      fixture.detectChanges();

      component.toggleShouldRender('v2');

      const setRenderCalls = viewFacadeSpy.setRender.calls;
      expect(setRenderCalls.count()).toEqual(0);
    });

    it('should toggleShouldRender not trigger viewFacade#setRender with non-matching view', () => {
      const appView = createViewDictionary([{name: 'v3'}]);
      viewFacadeSpy.getAppView.and.returnValue(of(appView));
      fixture.detectChanges();

      component.toggleShouldRender('v1');

      const setRenderCalls = viewFacadeSpy.setRender.calls;
      expect(setRenderCalls.count()).toEqual(0);
    });

    it('should toggleShouldRender trigger viewFacade#setRender with enabled matching view', () => {
      const appView = createViewDictionary([{name: 'v1'}]);
      viewFacadeSpy.getAppView.and.returnValue(of(appView));
      fixture.detectChanges();

      component.toggleShouldRender('v1');

      const setRenderCalls = viewFacadeSpy.setRender.calls;
      expect(setRenderCalls.count()).toEqual(1);
      expect(setRenderCalls.argsFor(0)).toEqual(['v1', true]);
    });
  });

  describe('Template', () => {
    describe('header', () => {
      const name = 'Justin Wheeler — ';
      const headerRoleSelector = '.header-role';

      it('should render logo', () => {
        fixture.detectChanges();
        const element = fixture.debugElement.query(By.css('.header-logo'));
        expect(element.properties.svgIcon).toEqual(component.provider);
      });

      it('should render role for desktop', () => {
        mockBreakpointObserver(Device.Desktop);
        fixture.detectChanges();

        const elements = fixture.debugElement.queryAll(By.css(headerRoleSelector));
        expect(elements.length).toEqual(1);

        // note: the value is set with css animations and @keyframes
        expect(elements[0].nativeElement.textContent.trim()).toEqual('');
      });

      it('should render role for mobile', () => {
        mockBreakpointObserver(Device.Mobile);
        fixture.detectChanges();

        const elements = fixture.debugElement.queryAll(By.css(headerRoleSelector));
        expect(elements.length).toEqual(1);
        expect(elements[0].nativeElement.textContent.trim()).toEqual(`${name}Cloud Guru`);
      });

      it('should render role for tablet', () => {
        mockBreakpointObserver(Device.Tablet);
        fixture.detectChanges();

        const elements = fixture.debugElement.queryAll(By.css(headerRoleSelector));
        expect(elements.length).toEqual(1);
        expect(elements[0].nativeElement.textContent.trim()).toEqual(`${name}Cloud Architect`);
      });
    });

    describe('body', () => {
      const sections = [
        'about',
        'experience',
        'certification',
        'skill',
        'project',
        'education',
        'visitor'
      ];

      it('should render 7 sections in order', () => {
        fixture.detectChanges();

        const element = fixture.debugElement.query(By.css('.body'));
        const children = element.children;
        const childrenLength = children.length;
        expect(childrenLength).toEqual(sections.length);

        for (let i = 0; i < childrenLength; i++){
          const child = children[i];
          expect(Object.keys(child.classes)[0]).toEqual(`body-${sections[i]}`);
        }
      });

      describe('section card', () => {
        it('should render for every section', () => {
          fixture.detectChanges();
          sections.forEach(section => {
            const card = getSectionCard(section);
            expect(card.name).toEqual('mat-card');
            expect(Object.keys(card.classes)).toContain('section-card');
          });
        });

        it('should set tabIndex to 0', () => {
          fixture.detectChanges();
          sections.forEach(section => {
            const card = getSectionCard(section);
            expect(card.nativeElement.tabIndex).toEqual(0);
          });
        });

        describe('view enabled', () => {
          beforeEach(() => {
            const appView: Dictionary<View> = createViewDictionary(
              sections.map(section => createView({name: section, enable: true, render: false}))
            );
            viewFacadeSpy.getAppView.and.returnValue(of(appView));
            fixture.detectChanges();
          });

          it('should classes not contain disabled', () => {
            sections.forEach(section => {
              const card = getSectionCard(section);
              expect(Object.keys(card.classes)).not.toContain('disabled');
            });
          });

          it('should click trigger viewFacade#setRender', () => {
            sections.forEach(section => {
              const card = getSectionCard(section);
              card.nativeElement.click();
            });

            const setRenderCalls = viewFacadeSpy.setRender.calls;
            expect(setRenderCalls.count()).toEqual(sections.length);
            for (let i = 0; i < sections.length; i++){
              expect(setRenderCalls.argsFor(i)).toEqual([sections[i], true]);
            }
          });

          it('should keydown.enter trigger viewFacade#setRender', () => {
            sections.forEach(section => {
              const card = getSectionCard(section);
              card.triggerEventHandler('keydown.enter', {});
            });

            const setRenderCalls = viewFacadeSpy.setRender.calls;
            expect(setRenderCalls.count()).toEqual(sections.length);
            for (let i = 0; i < sections.length; i++){
              expect(setRenderCalls.argsFor(i)).toEqual([sections[i], true]);
            }
          });
        });

        describe('view disabled', () => {
          beforeEach(() => {
            const appView: Dictionary<View> = createViewDictionary(
              sections.map(section => createView({name: section, enable: false, render: false}))
            );
            viewFacadeSpy.getAppView.and.returnValue(of(appView));
            fixture.detectChanges();
          });

          it('should classes contain disabled', () => {
            sections.forEach(section => {
              const card = getSectionCard(section);
              expect(Object.keys(card.classes)).toContain('disabled');
            });
          });

          it('should click not trigger viewFacade#setRender', () => {
            sections.forEach(section => {
              const card = getSectionCard(section);
              card.nativeElement.click();
            });

            const setRenderCalls = viewFacadeSpy.setRender.calls;
            expect(setRenderCalls.count()).toEqual(0);
          });

          it('should keydown.enter not trigger viewFacade#setRender', () => {
            sections.forEach(section => {
              const card = getSectionCard(section);
              card.triggerEventHandler('keydown.enter', {});
            });

            const setRenderCalls = viewFacadeSpy.setRender.calls;
            expect(setRenderCalls.count()).toEqual(0);
          });
        });

        function getSectionCard(section: string): DebugElement {
          return fixture.debugElement.query(By.css(`.body-${section}`)).children[0];
        }
      });
    });

    describe('footer', () => {
      it('should render mat-divider', () => {
        fixture.detectChanges();
        const element = fixture.debugElement.query(By.css('.footer > mat-divider'));
        expect(element).toBeTruthy();
      });
    });
  });

  function mockBreakpointObserver(device: Device): void {
    const breakpointState: BreakpointState = {
      breakpoints: {
        '(max-width: 425px)': Device.Mobile === device,
        '(max-width: 768px)': Device.Tablet === device
      },
      matches: true
    };
    breakpointObserverSpy.observe.and.returnValue(of(breakpointState));
  }
});
