import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {AppComponent} from "../../../app.component";
import {tap} from "rxjs/operators";
import {Skill, SkillState} from "../../store/skill/skill.state";

@Injectable({
  providedIn: 'root'
})
export class SkillService {

  constructor(private httpClient: HttpClient) {}

  retrieve(): Observable<SkillState> {
    return this.httpClient
      .get<SkillState>(AppComponent.api.skill.retrieve)
      .pipe(tap(state => SkillService.sort(state)));
  }

  private static sort(state: SkillState): SkillState {
    state.data.sort((n1, n2) => {
      const c1 = SkillService.compareType(n1, n2, true);
      const c2 = SkillService.compareName(n1, n2, true);
      return c1 == 0 ? c2 : c1;
    });
    return state;
  }

  private static compareName(n1: Skill, n2: Skill, asc: boolean) : number {
    return (n1.name == n2.name ? 0 : n1.name > n2.name ? 1 : -1) * (asc ? 1 : -1);
  }

  private static compareType(n1: Skill, n2: Skill, asc: boolean) : number {
    return (n1.type == n2.type ? 0 : n1.type > n2.type ? 1 : -1) * (asc ? 1 : -1);
  }
}
