import {
  CertificationActionType,
  CertificationRetrieveAction,
  CertificationRetrieveSuccessAction,
} from './certification.actions';
import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { CertificationService } from '../../service/certification/certification.service';
import { Action } from '@ngrx/store';
import { catchError, map, switchMap } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import {ErrorAction} from "../general/general.actions";

@Injectable()
export class CertificationEffects {
  constructor(private actions$: Actions, private certificationService: CertificationService) {}

  retrieve$: Observable<Action> = createEffect(() => {
    return this.actions$.pipe(
      ofType<CertificationRetrieveAction>(CertificationActionType.Retrieve),
      switchMap(() => {
        return this.certificationService.retrieve().pipe(
          map((state) => new CertificationRetrieveSuccessAction(state)),
          catchError((error) => of(new ErrorAction(error)))
        );
      })
    );
  });
}
