import {Component, forwardRef, InjectionToken, OnInit} from '@angular/core';
import {View, ViewType} from "./shared/model/view.model";

export const AppInjectionToken = new InjectionToken<AppComponent>('AppComponentInjectionToken')

@Component({
  providers: [{
    provide: AppInjectionToken,
    useExisting: forwardRef(() => AppComponent)
  }],
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

  aboutView: View = {
    shouldEnable: true,
    shouldRender: false
  }

  certificationView: View = {
    shouldEnable: true,
    shouldRender: false
  }

  educationView: View = {
    shouldEnable: true,
    shouldRender: false
  }

  experienceView: View = {
    shouldEnable: true,
    shouldRender: false
  }

  projectView: View = {
    shouldEnable: true,
    shouldRender: false
  }

  skillView: View = {
    shouldEnable: true,
    shouldRender: false
  }

  role = 'Cloud Architect';
  viewType = ViewType;

  ngOnInit(): void {}

  toggleViewShouldRender(view: View): void {
    if (view.shouldEnable) {
      view.shouldRender = !view.shouldRender;
    }
  }
}
