import { EducationActionType, EducationRetrieveAction, EducationRetrieveSuccessAction } from './education.actions';
import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { Action } from '@ngrx/store';
import { catchError, map, switchMap } from 'rxjs/operators';
import { ErrorAction } from '../error/error.actions';
import { Observable, of } from 'rxjs';
import { EducationService } from '../../service/education/education.service';

@Injectable()
export class EducationEffects {
  constructor(private actions$: Actions, private service: EducationService) {}

  retrieve$: Observable<Action> = createEffect(() => {
    return this.actions$.pipe(
      ofType<EducationRetrieveAction>(EducationActionType.Retrieve),
      switchMap(() => {
        return this.service.retrieve().pipe(
          map((state) => new EducationRetrieveSuccessAction(state)),
          catchError((error) => of(new ErrorAction(error)))
        );
      })
    );
  });
}
