import {Store} from '@ngrx/store';
import {AppState} from '../app.state';
import {Injectable} from '@angular/core';
import {ViewSetEnableAction, ViewSetRenderAction} from './view.actions';
import {View} from './view.state';
import {viewEntitiesSelector, viewEntitySelector} from './view.selector';
import {Observable} from 'rxjs';
import {Dictionary} from '@ngrx/entity';

@Injectable({ providedIn: 'root' })
export class ViewFacade {
  constructor(private store: Store<AppState>) {}

  getAppView(): Observable<Dictionary<View>> {
    return this.store.select(viewEntitiesSelector);
  }

  getView(name: string): Observable<View> {
    return this.store.select(viewEntitySelector(name));
  }

  setEnable(name: string, value: boolean): void {
    this.store.dispatch(new ViewSetEnableAction(name, value));
  }

  setRender(name: string, value: boolean): void {
    this.store.dispatch(new ViewSetRenderAction(name, value));
  }
}
