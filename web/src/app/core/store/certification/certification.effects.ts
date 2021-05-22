import {
  CertificationActionType,
  CertificationRetrieveAction,
  CertificationRetrieveSuccessAction
} from "./certification.actions";
import {Injectable} from "@angular/core";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {CertificationService} from "../../service/certification/certification.service";
import {Action} from "@ngrx/store";
import {catchError, map, switchMap} from "rxjs/operators";
import {ErrorAction} from "../error/error.actions";
import {Observable, of} from "rxjs";

@Injectable()
export class CertificationEffects {

  constructor(
    private actions$: Actions,
    private service: CertificationService
  ) {}

  retrieve$: Observable<Action> = createEffect(() => {
    return this.actions$.pipe(
      ofType<CertificationRetrieveAction>(CertificationActionType.Retrieve),
      switchMap(() => {
        return this.service.retrieve().pipe(
          map(state => new CertificationRetrieveSuccessAction(state)),
          catchError(error => of(new ErrorAction(error)))
        )
      })
    );
  });
}
