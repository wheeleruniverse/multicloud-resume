import {Pipe, PipeTransform} from "@angular/core";
import {MonthYear} from "../models/month-year";

@Pipe({
  name: 'formatDate',
  pure: true
})
export class FormatDatePipe implements PipeTransform {

  transform(value: MonthYear, args?: any): string {
    return value != null ? `${value.month} ${value.year}` : 'Current';
  }
}
