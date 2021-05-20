import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {Project} from "./project.model";
import {HttpClient} from "@angular/common/http";
import {AppComponent} from "../app.component";
import {tap} from "rxjs/operators";
import {MonthYearService} from "../shared/service/month-year.service";

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor(private httpClient: HttpClient) {}

  get(): Observable<Project[]> {
    return this.httpClient
      .get<Project[]>(AppComponent.api.project.retrieve)
      .pipe(tap(data => ProjectService.sort(data)));
  }

  private static sort(data: Project[]): Project[] {
    return data.sort((n1, n2) => {
      return MonthYearService.compare(n1.start, n2.start, false);
    });
  }
}
