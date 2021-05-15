import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  private static readonly root = "https://wheeler-resume-app.azurewebsites.net/api";

  static readonly api = {
    certification: {
      retrieve: `${AppComponent.root}/certification/retrieve`
    },
    education: {
      retrieve: `${AppComponent.root}/education/retrieve`
    },
    experience: {
      retrieve: `${AppComponent.root}/experience/retrieve`
    },
    project: {
      retrieve: `${AppComponent.root}/project/retrieve`
    },
    skill: {
      retrieve: `${AppComponent.root}/skill/retrieve`
    },
    visitor: {
      count: `${AppComponent.root}/visitor/count`,
      create: `${AppComponent.root}/visitor/create`,
      retrieve: `${AppComponent.root}/visitor/retrieve`
    }
  }

  role = 'Cloud Architect';
  view = new Map<string, boolean>();

  ngOnInit(): void {
    this.view.set('education', false);
    this.view.set('experience', false);
    this.view.set('certifications', false);
    this.view.set('projects', false);
    this.view.set('skills', false);

    console.log(window.navigator.userAgent);
  }

  toggleView(key: string): void {
    this.view.set(key, !this.view.get(key));
  }
}
