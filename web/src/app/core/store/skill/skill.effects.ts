import { SkillActionType, SkillRetrieveAction, SkillRetrieveSuccessAction } from './skill.actions';
import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { Action } from '@ngrx/store';
import { catchError, map, switchMap } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { SkillService } from '../../service/skill/skill.service';
import {ErrorAction} from "../general/general.actions";

@Injectable()
export class SkillEffects {
  constructor(private actions$: Actions, private skillService: SkillService) {}

  retrieve$: Observable<Action> = createEffect(() => {
    return this.actions$.pipe(
      ofType<SkillRetrieveAction>(SkillActionType.Retrieve),
      switchMap(() => {
        return this.skillService.retrieve().pipe(
          map((state) => new SkillRetrieveSuccessAction(state)),
          catchError((error) => of(new ErrorAction(error)))
        );
      })
    );
  });
}
