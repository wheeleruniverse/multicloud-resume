import {Store} from "@ngrx/store";
import {SkillState} from "./skill.state";
import {AppState} from "../app.state";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {tap} from "rxjs/operators";
import {skillStateSelector} from "./skill.selector";
import {SkillRetrieveAction} from "./skill.actions";

@Injectable({providedIn: 'root'})
export class SkillFacade {

  constructor(private store: Store<AppState>) {}

  retrieve(): Observable<SkillState> {
    return this.store.select(skillStateSelector).pipe(
      tap(state => {
        if(state?.data == null){
          this.store.dispatch(new SkillRetrieveAction());
        }
      })
    );
  }
}

