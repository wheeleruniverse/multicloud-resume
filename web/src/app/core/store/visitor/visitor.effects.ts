import {
  VisitorActionType,
  VisitorCountAction,
  VisitorCountSuccessAction,
  VisitorIncrementAction, VisitorIncrementFailureAction, VisitorIncrementSuccessAction
} from './visitor.actions';
import {Injectable} from '@angular/core';
import {Actions, createEffect, ofType} from '@ngrx/effects';
import {Action} from '@ngrx/store';
import {catchError, map, switchMap, tap} from 'rxjs/operators';
import {Observable, of} from 'rxjs';
import {VisitorService} from "../../service/visitor/visitor.service";
import {CookieService} from "ngx-cookie-service";
import {MatSnackBar, MatSnackBarConfig} from "@angular/material/snack-bar";
import {environment} from "../../../../environments/environment";
import {ErrorAction, NoOpAction} from "../general/general.actions";

@Injectable()
export class VisitorEffects {
  private readonly cookie: string = `${environment.provider}-visitor`;
  private readonly snackBarConfig: MatSnackBarConfig = {
    duration: 3000
  };

  constructor(
    private actions$: Actions,
    private cookieService: CookieService,
    private snackBar: MatSnackBar,
    private visitorService: VisitorService,
  ) {}

  count$: Observable<Action> = createEffect(() => {
    return this.actions$.pipe(
      ofType<VisitorCountAction>(VisitorActionType.Count),
      switchMap(() => {
        return this.visitorService.count().pipe(
          map((state) => new VisitorCountSuccessAction(state)),
          catchError((error) => of(new ErrorAction(error)))
        );
      })
    );
  });

  countSuccess$: Observable<Action> = createEffect(() => {
    return this.actions$.pipe(
      ofType<VisitorCountSuccessAction>(VisitorActionType.CountSuccess),
      map(() => {
        if(this.cookieService.check(this.cookie)){
          return new NoOpAction('visitor already exists');
        }
        return new VisitorIncrementAction();
      })
    );
  });

  increment$: Observable<Action> = createEffect(() => {
    return this.actions$.pipe(
      ofType<VisitorIncrementAction>(VisitorActionType.Increment),
      switchMap(() => {
        return this.visitorService.increment().pipe(
          map((response) => {
            if([200, 201, 204].includes(response.status)){
              return new VisitorIncrementSuccessAction();
            }
            return new VisitorIncrementFailureAction();
          }),
          catchError((error) => of(new VisitorIncrementFailureAction(error)))
        );
      })
    );
  });

  incrementFailure$: Observable<Action> = createEffect(
    () => {
      return this.actions$.pipe(
        ofType<VisitorIncrementFailureAction>(VisitorActionType.IncrementFailure),
        tap(() => this.snackBar.open('New Visitor Failure!', null, this.snackBarConfig))
      );
    },
    { dispatch: false }
  );

  incrementSuccess$: Observable<Action> = createEffect(
    () => {
      return this.actions$.pipe(
        ofType<VisitorIncrementSuccessAction>(VisitorActionType.IncrementSuccess),
        tap(() => {
          this.cookieService.set(this.cookie, 'true', 30);
          this.snackBar.open('New Visitor Success!', null, this.snackBarConfig);
        })
      );
    },
    { dispatch: false }
  );
}
