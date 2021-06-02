import { Pipe, PipeTransform } from '@angular/core';
import { MonthYear } from '../model/month-year.model';

@Pipe({
  name: 'monthYear',
  pure: true,
})
export class MonthYearPipe implements PipeTransform {
  transform(value: MonthYear, args?: any): string {
    return value != null ? `${value.month} ${value.year}` : 'Current';
  }
}
