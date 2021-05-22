import {ExperienceActionType, ExperienceRetrieveAction, ExperienceRetrieveSuccessAction} from "./experience.actions";
import {Injectable} from "@angular/core";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {Action} from "@ngrx/store";
import {catchError, map, switchMap} from "rxjs/operators";
import {ErrorAction} from "../error/error.actions";
import {Observable, of} from "rxjs";
import {ExperienceService} from "../../service/experience/experience.service";

@Injectable()
export class ExperienceEffects {

  constructor(
    private actions$: Actions,
    private service: ExperienceService
  ) {}

  retrieve$: Observable<Action> = createEffect(() => {
    return this.actions$.pipe(
      ofType<ExperienceRetrieveAction>(ExperienceActionType.Retrieve),
      switchMap(() => {
        return this.service.retrieve().pipe(
          map(state => new ExperienceRetrieveSuccessAction(state)),
          catchError(error => of(new ErrorAction(error)))
        )
      })
    );
  });
}
