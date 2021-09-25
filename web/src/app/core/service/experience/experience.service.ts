import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { AppComponent } from '../../../app.component';
import { tap } from 'rxjs/operators';
import { MonthYearService } from '../../../shared/service/month-year.service';
import { ExperienceState } from '../../store/experience/experience.state';
import {backend} from "../../../shared/utility/backend.utility";

@Injectable({
  providedIn: 'root',
})
export class ExperienceService {
  constructor(private httpClient: HttpClient) {}

  private static sort(state: ExperienceState): ExperienceState {
    state.data.sort((n1, n2) => {
      return MonthYearService.compare(n1.start, n2.start, false);
    });
    return state;
  }

  retrieve(): Observable<ExperienceState> {
    return this.httpClient
      .get<ExperienceState>(backend.experience.retrieve)
      .pipe(tap((state) => ExperienceService.sort(state)));
  }
}
