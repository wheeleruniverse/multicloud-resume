import {MonthYear} from "../model/month-year.model";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class MonthYearService {

  constructor() {}

  static compare(n1: MonthYear, n2: MonthYear, asc: boolean): number {
    const v1 = (n1.year == n2.year ? 0 : n1.year > n2.year ? 1 : -1) * (asc ? 1 : -1);
    const v2 = (n1.month == n2.month ? 0 : n1.month > n2.month ? 1 : -1) * (asc ? 1 : -1);
    return v1 == 0 ? v2 : v1;
  }
}
