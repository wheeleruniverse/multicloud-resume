import { Store } from '@ngrx/store';
import { EducationState } from './education.state';
import { AppState } from '../app.state';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { educationStateSelector } from './education.selector';
import { tap } from 'rxjs/operators';
import { EducationRetrieveAction } from './education.actions';

@Injectable({ providedIn: 'root' })
export class EducationFacade {
  constructor(private store: Store<AppState>) {}

  retrieve(): Observable<EducationState> {
    return this.store.select(educationStateSelector).pipe(
      tap((state) => {
        if (state?.data == null) {
          this.store.dispatch(new EducationRetrieveAction());
        }
      })
    );
  }
}
