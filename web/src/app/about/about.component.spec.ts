import {ComponentFixture, TestBed} from '@angular/core/testing';

import {AboutComponent} from './about.component';
import {By} from '@angular/platform-browser';
import {CUSTOM_ELEMENTS_SCHEMA} from '@angular/core';

describe('AboutComponent', () => {
  let component: AboutComponent;
  let fixture: ComponentFixture<AboutComponent>;

  beforeEach(() => {
    // TestBed
    TestBed.configureTestingModule({
      declarations: [AboutComponent],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    }).compileComponents();

    // Component
    fixture = TestBed.createComponent(AboutComponent);
    component = fixture.componentInstance;
  });

  it('should create', () => {
    fixture.detectChanges();
    expect(component).toBeTruthy();
  });

  describe('Component', () => {
    it('should default count to range between index and total (exclusive)', () => {
      expect(component.count).toEqual([0, 1]);
    });

    it('should default index to 0', () => {
      expect(component.index).toEqual(0);
    });

    it('should default total to 2', () => {
      expect(component.total).toEqual(2);
    });

    it('should photoUrlForIndex correctly format the url', () => {
      component.index = 9;
      expect(component.photoUrlForIndex).toEqual('assets/about/photo/9.png');
    });

    it('should setIndex correctly set the index', () => {
      component.index = 1;
      component.setIndex(3);
      expect(component.index).toEqual(3);
    });
  });

  describe('Template', () => {
    it('should render about', () => {
      const about = fixture.debugElement.query(By.css('.about'));
      expect(about).toBeTruthy();
    });
  });
});
