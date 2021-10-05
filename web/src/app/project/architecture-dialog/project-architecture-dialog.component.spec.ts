import {ComponentFixture, TestBed} from '@angular/core/testing';

import {ProjectArchitectureDialogComponent} from './project-architecture-dialog.component';

xdescribe('ProjectArchitectureDialogComponent', () => {
  let component: ProjectArchitectureDialogComponent;
  let fixture: ComponentFixture<ProjectArchitectureDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ProjectArchitectureDialogComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectArchitectureDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
