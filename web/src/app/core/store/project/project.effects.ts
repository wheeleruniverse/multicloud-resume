import { ProjectActionType, ProjectRetrieveAction, ProjectRetrieveSuccessAction } from './project.actions';
import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { Action } from '@ngrx/store';
import { catchError, map, switchMap } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { ProjectService } from '../../service/project/project.service';
import {ErrorAction} from "../general/general.actions";

@Injectable()
export class ProjectEffects {
  constructor(private actions$: Actions, private projectService: ProjectService) {}

  retrieve$: Observable<Action> = createEffect(() => {
    return this.actions$.pipe(
      ofType<ProjectRetrieveAction>(ProjectActionType.Retrieve),
      switchMap(() => {
        return this.projectService.retrieve().pipe(
          map((state) => new ProjectRetrieveSuccessAction(state)),
          catchError((error) => of(new ErrorAction(error)))
        );
      })
    );
  });
}
