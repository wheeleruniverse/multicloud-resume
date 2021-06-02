import {
  ProjectActionType,
  ProjectRetrieveAction,
  ProjectRetrieveSuccessAction,
} from './project.actions';
import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { Action } from '@ngrx/store';
import { catchError, map, switchMap } from 'rxjs/operators';
import { ErrorAction } from '../error/error.actions';
import { Observable, of } from 'rxjs';
import { ProjectService } from '../../service/project/project.service';

@Injectable()
export class ProjectEffects {
  constructor(private actions$: Actions, private service: ProjectService) {}

  retrieve$: Observable<Action> = createEffect(() => {
    return this.actions$.pipe(
      ofType<ProjectRetrieveAction>(ProjectActionType.Retrieve),
      switchMap(() => {
        return this.service.retrieve().pipe(
          map((state) => new ProjectRetrieveSuccessAction(state)),
          catchError((error) => of(new ErrorAction(error)))
        );
      })
    );
  });
}
