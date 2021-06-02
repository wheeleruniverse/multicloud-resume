import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ViewService } from './shared/service/view.service';
import { BreakpointObserver } from '@angular/cdk/layout';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit {
  constructor(
    private breakpointObserver: BreakpointObserver,
    private changeDetectorRef: ChangeDetectorRef,
    private viewService: ViewService
  ) {}

  private static readonly root =
    'https://wheeler-resume-app.azurewebsites.net/api';

  static readonly api = {
    certification: {
      retrieve: `${AppComponent.root}/certification/retrieve`,
    },
    education: {
      retrieve: `${AppComponent.root}/education/retrieve`,
    },
    experience: {
      retrieve: `${AppComponent.root}/experience/retrieve`,
    },
    project: {
      retrieve: `${AppComponent.root}/project/retrieve`,
    },
    skill: {
      retrieve: `${AppComponent.root}/skill/retrieve`,
    },
    visitor: {
      count: `${AppComponent.root}/visitor/count`,
      create: `${AppComponent.root}/visitor/create`,
      retrieve: `${AppComponent.root}/visitor/retrieve`,
    },
  };

  isMobile = false;
  isTablet = false;

  aboutShouldRender = false;

  certificationShouldEnable = true;
  certificationShouldRender = false;

  educationShouldEnable = true;
  educationShouldRender = false;

  experienceShouldEnable = true;
  experienceShouldRender = false;

  projectShouldEnable = true;
  projectShouldRender = false;

  skillShouldEnable = true;
  skillShouldRender = false;

  ngOnInit(): void {
    const mobileBreakPoint = '(max-width: 425px)';
    const tabletBreakPoint = '(max-width: 768px)';

    this.breakpointObserver
      .observe([mobileBreakPoint, tabletBreakPoint])
      .subscribe((result) => {
        if (result.breakpoints[mobileBreakPoint]) {
          this.isMobile = true;
          this.isTablet = false;
        } else if (result.breakpoints[tabletBreakPoint]) {
          this.isMobile = false;
          this.isTablet = true;
        } else {
          this.isMobile = false;
          this.isTablet = false;
        }
        this.closeView();
      });

    this.viewService.certificationShouldEnable$.subscribe((val) => {
      this.certificationShouldEnable = val;
      this.changeDetectorRef.detectChanges();
    });
    this.viewService.certificationShouldRender$.subscribe((val) => {
      this.certificationShouldRender = val;
      this.changeDetectorRef.detectChanges();
    });

    this.viewService.educationShouldEnable$.subscribe((val) => {
      this.educationShouldEnable = val;
      this.changeDetectorRef.detectChanges();
    });
    this.viewService.educationShouldRender$.subscribe((val) => {
      this.educationShouldRender = val;
      this.changeDetectorRef.detectChanges();
    });

    this.viewService.experienceShouldEnable$.subscribe((val) => {
      this.experienceShouldEnable = val;
      this.changeDetectorRef.detectChanges();
    });
    this.viewService.experienceShouldRender$.subscribe((val) => {
      this.experienceShouldRender = val;
      this.changeDetectorRef.detectChanges();
    });

    this.viewService.projectShouldEnable$.subscribe((val) => {
      this.projectShouldEnable = val;
      this.changeDetectorRef.detectChanges();
    });
    this.viewService.projectShouldRender$.subscribe((val) => {
      this.projectShouldRender = val;
      this.changeDetectorRef.detectChanges();
    });

    this.viewService.skillShouldEnable$.subscribe((val) => {
      this.skillShouldEnable = val;
      this.changeDetectorRef.detectChanges();
    });
    this.viewService.skillShouldRender$.subscribe((val) => {
      this.skillShouldRender = val;
      this.changeDetectorRef.detectChanges();
    });
  }

  closeView(): void {
    this.viewService.certificationShouldRender(false);
    this.viewService.educationShouldRender(false);
    this.viewService.experienceShouldRender(false);
    this.viewService.projectShouldRender(false);
    this.viewService.skillShouldRender(false);
  }

  toggleAboutShouldRender(): void {
    this.aboutShouldRender = !this.aboutShouldRender;
  }

  toggleCertificationShouldRender(): void {
    if (this.certificationShouldEnable) {
      this.viewService.certificationShouldRender(
        !this.certificationShouldRender
      );
    }
  }

  toggleEducationShouldRender(): void {
    if (this.educationShouldEnable) {
      this.viewService.educationShouldRender(!this.educationShouldRender);
    }
  }

  toggleExperienceShouldRender(): void {
    if (this.experienceShouldEnable) {
      this.viewService.experienceShouldRender(!this.experienceShouldRender);
    }
  }

  toggleProjectShouldRender(): void {
    if (this.projectShouldEnable) {
      this.viewService.projectShouldRender(!this.projectShouldRender);
    }
  }

  toggleSkillShouldRender(): void {
    if (this.skillShouldEnable) {
      this.viewService.skillShouldRender(!this.skillShouldRender);
    }
  }
}
