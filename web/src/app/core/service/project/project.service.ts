import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { AppComponent } from '../../../app.component';
import { tap } from 'rxjs/operators';
import { MonthYearService } from '../../../shared/service/month-year.service';
import { ProjectState } from '../../store/project/project.state';
import {backend} from "../../../shared/utility/backend.utility";

@Injectable({
  providedIn: 'root',
})
export class ProjectService {
  constructor(private httpClient: HttpClient) {}

  private static sort(state: ProjectState): ProjectState {
    state.data.sort((n1, n2) => {
      return MonthYearService.compare(n1.start, n2.start, false);
    });
    return state;
  }

  retrieve(): Observable<ProjectState> {
    return this.httpClient
      .get<ProjectState>(backend.project.retrieve)
      .pipe(tap((state) => ProjectService.sort(state)));
  }
}
