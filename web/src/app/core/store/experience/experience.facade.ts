import { Store } from '@ngrx/store';
import { ExperienceState } from './experience.state';
import { AppState } from '../app.state';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { experienceStateSelector } from './experience.selector';
import { ExperienceRetrieveAction } from './experience.actions';

@Injectable({ providedIn: 'root' })
export class ExperienceFacade {
  constructor(private store: Store<AppState>) {}

  retrieve(): Observable<ExperienceState> {
    return this.store.select(experienceStateSelector).pipe(
      tap((state) => {
        if (state?.data == null) {
          this.store.dispatch(new ExperienceRetrieveAction());
        }
      })
    );
  }
}
