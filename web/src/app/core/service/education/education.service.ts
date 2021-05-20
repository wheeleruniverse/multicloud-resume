import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {Education} from "../../../education/education.model";
import {HttpClient} from "@angular/common/http";
import {AppComponent} from "../../../app.component";

@Injectable({
  providedIn: 'root'
})
export class EducationService {

  constructor(private httpClient: HttpClient) {}

  get(): Observable<Education[]> {
    return this.httpClient.get<Education[]>(AppComponent.api.education.retrieve);
  }
}
