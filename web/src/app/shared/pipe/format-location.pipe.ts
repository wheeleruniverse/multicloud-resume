import {Pipe, PipeTransform} from "@angular/core";
import {Location} from "../models/location";

@Pipe({
  name: 'formatLocation',
  pure: true
})
export class FormatLocationPipe implements PipeTransform {

  transform(value: Location, args?: any): string {
    return value != null ? `${value.address}, ${value.city}, ${value.state} ${value.zip}` : '';
  }
}
