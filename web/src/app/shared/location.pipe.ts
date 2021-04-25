import {Pipe, PipeTransform} from "@angular/core";
import {Location} from "./location.model";

@Pipe({
  name: 'location',
  pure: true
})
export class LocationPipe implements PipeTransform {

  transform(value: Location, args?: any): string {
    return value != null ? `${value.address}, ${value.city}, ${value.state} ${value.zip}` : '';
  }
}
