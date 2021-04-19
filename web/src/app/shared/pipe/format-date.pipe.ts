import {Pipe, PipeTransform} from "@angular/core";
import {Date} from "../date";

@Pipe({
  name: 'formatDate',
  pure: true
})
export class FormatDatePipe implements PipeTransform {

  transform(value: Date, args?: any): string {
    return value != null ? `${value.month} ${value.year}` : 'Current';
  }
}
