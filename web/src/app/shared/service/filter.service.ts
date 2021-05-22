import {Injectable} from "@angular/core";
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FilterService {

  public target$ = new BehaviorSubject('');

  constructor() {}

  public setTarget(target: string): void {
    this.target$.next(target.trim().toLowerCase());
  }
}
