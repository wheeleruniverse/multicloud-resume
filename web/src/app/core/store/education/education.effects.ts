import { EducationActionType, EducationRetrieveAction, EducationRetrieveSuccessAction } from './education.actions';
import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { Action } from '@ngrx/store';
import { catchError, map, switchMap } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { EducationService } from '../../service/education/education.service';
import {ErrorAction} from "../general/general.actions";

@Injectable()
export class EducationEffects {
  constructor(private actions$: Actions, private educationService: EducationService) {}

  retrieve$: Observable<Action> = createEffect(() => {
    return this.actions$.pipe(
      ofType<EducationRetrieveAction>(EducationActionType.Retrieve),
      switchMap(() => {
        return this.educationService.retrieve().pipe(
          map((state) => new EducationRetrieveSuccessAction(state)),
          catchError((error) => of(new ErrorAction(error)))
        );
      })
    );
  });
}
