import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {tap} from "rxjs/operators";
import {MetaData} from "../../../shared/model/meta-data.model";
import {AppComponent} from "../../../app.component";
import {Certification, CertificationState} from "../../store/certification/certification.state";

@Injectable({
  providedIn: 'root'
})
export class CertificationService {

  constructor(private httpClient: HttpClient) {}

  retrieve(): Observable<CertificationState> {
    return this.httpClient
      .get<CertificationState>(AppComponent.api.certification.retrieve)
      .pipe(tap(state => CertificationService.sort(state)));
  }

  private static sort(state: CertificationState): CertificationState {

    const lookupLevel = (i: Certification) => state.meta.levels.find(meta => meta.name === i.level);

    state.data.sort((n1, n2) => {
      const c1 = CertificationService.compareVendor(n1, n2, true);
      const c2 = CertificationService.compareLevel(n1, n2, false, lookupLevel);
      const c3 = CertificationService.compareName(n1, n2, true);
      return c1 == 0 ? c2 == 0 ? c3 : c2 : c1;
    });
    return state;
  }

  private static compareLevel(
    n1: Certification, n2: Certification, asc: boolean, lookup: (i:Certification) => MetaData): number {

    const v1 = lookup(n1);
    const v2 = lookup(n2);
    return (v1.rank == v2.rank ? 0 : v1.rank > v2.rank ? 1 : -1) * (asc ? 1 : -1);
  }

  private static compareName = (n1: Certification, n2: Certification, asc: boolean):
    number => (n1.name == n2.name ? 0 : n1.name > n2.name ? 1 : -1) * (asc ? 1 : -1);

  private static compareVendor = (n1: Certification, n2: Certification, asc: boolean):
    number => (n1.vendor == n2.vendor ? 0 : n1.vendor > n2.vendor ? 1 : -1) * (asc ? 1 : -1);
}
