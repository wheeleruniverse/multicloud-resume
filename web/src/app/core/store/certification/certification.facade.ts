import { Store } from '@ngrx/store';
import { CertificationState } from './certification.state';
import { AppState } from '../app.state';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { certificationStateSelector } from './certification.selector';
import { tap } from 'rxjs/operators';
import { CertificationRetrieveAction } from './certification.actions';

@Injectable({ providedIn: 'root' })
export class CertificationFacade {
  constructor(private store: Store<AppState>) {}

  retrieve(): Observable<CertificationState> {
    return this.store.select(certificationStateSelector).pipe(
      tap((state) => {
        if (state?.data == null) {
          this.store.dispatch(new CertificationRetrieveAction());
        }
      })
    );
  }
}
