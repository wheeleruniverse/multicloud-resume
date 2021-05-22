import {Injectable} from '@angular/core';
import {Experience} from "../../../experience/experience.model";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {AppComponent} from "../../../app.component";
import {tap} from "rxjs/operators";
import {MonthYearService} from "../../../shared/service/month-year.service";

@Injectable({
  providedIn: 'root'
})
export class ExperienceService {

  constructor(private httpClient: HttpClient) {}

  get(): Observable<Experience[]> {
    return this.httpClient
      .get<Experience[]>(AppComponent.api.experience.retrieve)
      .pipe(tap(data => ExperienceService.sort(data)));
  }

  private static sort(data: Experience[]): Experience[] {
    return data.sort((n1, n2) => {
      return MonthYearService.compare(n1.start, n2.start, false);
    });
  }
}


