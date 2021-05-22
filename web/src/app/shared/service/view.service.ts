import {Injectable} from "@angular/core";
import {BehaviorSubject, Observable, ReplaySubject, Subject} from "rxjs";
import {debounceTime, distinctUntilChanged} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class ViewService {

  public certificationShouldEnable$ = new BehaviorSubject<boolean>(true);
  public certificationShouldRender$ = new BehaviorSubject<boolean>(false);

  constructor(){}

  public setCertificationShouldEnable(value: boolean): void {
    this.certificationShouldEnable$.next(value);
  }

  public setCertificationShouldRender(value: boolean): void {
    this.certificationShouldRender$.next(value);
  }
}
