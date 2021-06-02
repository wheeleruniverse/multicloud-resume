import {
  SkillActionType,
  SkillRetrieveAction,
  SkillRetrieveSuccessAction,
} from './skill.actions';
import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { Action } from '@ngrx/store';
import { catchError, map, switchMap } from 'rxjs/operators';
import { ErrorAction } from '../error/error.actions';
import { Observable, of } from 'rxjs';
import { SkillService } from '../../service/skill/skill.service';

@Injectable()
export class SkillEffects {
  constructor(private actions$: Actions, private service: SkillService) {}

  retrieve$: Observable<Action> = createEffect(() => {
    return this.actions$.pipe(
      ofType<SkillRetrieveAction>(SkillActionType.Retrieve),
      switchMap(() => {
        return this.service.retrieve().pipe(
          map((state) => new SkillRetrieveSuccessAction(state)),
          catchError((error) => of(new ErrorAction(error)))
        );
      })
    );
  });
}
