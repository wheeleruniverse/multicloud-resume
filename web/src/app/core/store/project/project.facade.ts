import {Store} from "@ngrx/store";
import {ProjectState} from "./project.state";
import {AppState} from "../app.state";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {tap} from "rxjs/operators";
import {projectStateSelector} from "./project.selector";
import {ProjectRetrieveAction} from "./project.actions";

@Injectable({providedIn: 'root'})
export class ProjectFacade {

  constructor(private store: Store<AppState>) {}

  retrieve(): Observable<ProjectState> {
    return this.store.select(projectStateSelector).pipe(
      tap(state => {
        if(state?.data == null){
          this.store.dispatch(new ProjectRetrieveAction());
        }
      })
    );
  }
}

