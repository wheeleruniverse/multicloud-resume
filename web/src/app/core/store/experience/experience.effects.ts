import { ExperienceActionType, ExperienceRetrieveAction, ExperienceRetrieveSuccessAction } from './experience.actions';
import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { Action } from '@ngrx/store';
import { catchError, map, switchMap } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { ExperienceService } from '../../service/experience/experience.service';
import {ErrorAction} from "../general/general.actions";

@Injectable()
export class ExperienceEffects {
  constructor(private actions$: Actions, private experienceService: ExperienceService) {}

  retrieve$: Observable<Action> = createEffect(() => {
    return this.actions$.pipe(
      ofType<ExperienceRetrieveAction>(ExperienceActionType.Retrieve),
      switchMap(() => {
        return this.experienceService.retrieve().pipe(
          map((state) => new ExperienceRetrieveSuccessAction(state)),
          catchError((error) => of(new ErrorAction(error)))
        );
      })
    );
  });
}
