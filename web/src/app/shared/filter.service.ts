import {Injectable} from "@angular/core";
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FilterService {

  public currentSearch$ : BehaviorSubject<string> = new BehaviorSubject('');

  constructor() {}

  public setCurrentSearch(searchTerm: string): void {
    this.currentSearch$.next(searchTerm.trim().toLowerCase());
  }
}
