import {Store} from "@ngrx/store";
import {ProjectCompositeState} from "./project.state";
import {AppState} from "../app.state";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {projectCompositeStateSelector} from "./project.selector";
import {ProjectRetrieveAction} from "./project.actions";
import {tap} from "rxjs/operators";
import {SkillRetrieveAction} from "../skill/skill.actions";

@Injectable({providedIn: 'root'})
export class ProjectFacade {

  constructor(private store: Store<AppState>) {}

  retrieve(): Observable<ProjectCompositeState> {
    return this.store.select(projectCompositeStateSelector).pipe(
      tap(state => {
        if(state?.projects == null){
          this.store.dispatch(new ProjectRetrieveAction());
        }
        if(state?.skills == null){
          this.store.dispatch(new SkillRetrieveAction());
        }
      })
    );
  }
}

