import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ViewService {
  public certificationShouldEnable$ = new BehaviorSubject<boolean>(true);
  public certificationShouldRender$ = new BehaviorSubject<boolean>(false);

  public educationShouldEnable$ = new BehaviorSubject<boolean>(true);
  public educationShouldRender$ = new BehaviorSubject<boolean>(false);

  public experienceShouldEnable$ = new BehaviorSubject<boolean>(true);
  public experienceShouldRender$ = new BehaviorSubject<boolean>(false);

  public projectShouldEnable$ = new BehaviorSubject<boolean>(true);
  public projectShouldRender$ = new BehaviorSubject<boolean>(false);

  public skillShouldEnable$ = new BehaviorSubject<boolean>(true);
  public skillShouldRender$ = new BehaviorSubject<boolean>(false);

  public certificationShouldEnable(value: boolean): void {
    this.certificationShouldEnable$.next(value);
  }
  public certificationShouldRender(value: boolean): void {
    this.certificationShouldRender$.next(value);
  }

  public educationShouldEnable(value: boolean): void {
    this.educationShouldEnable$.next(value);
  }
  public educationShouldRender(value: boolean): void {
    this.educationShouldRender$.next(value);
  }

  public experienceShouldEnable(value: boolean): void {
    this.experienceShouldEnable$.next(value);
  }
  public experienceShouldRender(value: boolean): void {
    this.experienceShouldRender$.next(value);
  }

  public projectShouldEnable(value: boolean): void {
    this.projectShouldEnable$.next(value);
  }
  public projectShouldRender(value: boolean): void {
    this.projectShouldRender$.next(value);
  }

  public skillShouldEnable(value: boolean): void {
    this.skillShouldEnable$.next(value);
  }
  public skillShouldRender(value: boolean): void {
    this.skillShouldRender$.next(value);
  }
}
