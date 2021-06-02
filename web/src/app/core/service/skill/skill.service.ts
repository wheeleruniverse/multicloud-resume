import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { AppComponent } from '../../../app.component';
import { tap } from 'rxjs/operators';
import { Skill, SkillState } from '../../store/skill/skill.state';

@Injectable({
  providedIn: 'root',
})
export class SkillService {
  constructor(private httpClient: HttpClient) {}

  private static sort(state: SkillState): SkillState {
    state.data.sort((n1, n2) => {
      return SkillService.compareName(n1, n2, true);
    });
    return state;
  }

  private static compareName(n1: Skill, n2: Skill, asc: boolean): number {
    return (n1.name === n2.name ? 0 : n1.name > n2.name ? 1 : -1) * (asc ? 1 : -1);
  }

  retrieve(): Observable<SkillState> {
    return this.httpClient
      .get<SkillState>(AppComponent.api.skill.retrieve)
      .pipe(tap((state) => SkillService.sort(state)));
  }
}
