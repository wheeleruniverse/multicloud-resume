import {Store} from '@ngrx/store';
import {AppState} from '../app.state';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {visitorValueSelector} from './visitor.selector';
import {tap} from 'rxjs/operators';
import {VisitorCountAction} from './visitor.actions';

@Injectable({ providedIn: 'root' })
export class VisitorFacade {
  constructor(private store: Store<AppState>) {}

  count(): Observable<number> {
    return this.store.select(visitorValueSelector).pipe(
      tap((value) => {
        if (value == null) {
          this.store.dispatch(new VisitorCountAction());
        }
      })
    );
  }
}
