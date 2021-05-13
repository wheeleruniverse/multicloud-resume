import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {Certification} from "./certification.model";
import {HttpClient} from "@angular/common/http";
import {tap} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class CertificationService {

  constructor(private httpClient: HttpClient) { }

  get(): Observable<Certification[]> {
    const url = "https://wheeler-resume-app.azurewebsites.net/api/certification/retrieve";
    return this.httpClient
      .get<Certification[]>(url)
      .pipe(tap(data => CertificationService.sort(data)));
  }

  private static sort(data: Certification[]) : Certification[] {
    return data.sort((n1, n2) => {
      const c1 = CertificationService.compareLevel(n1, n2, false);
      const c2 = CertificationService.compareName(n1, n2, true);
      return c1 == 0 ? c2 : c1;
    });
  }

  private static compareLevel(n1: Certification, n2: Certification, asc: boolean) : number {
    return (n1.level == n2.level ? 0 : n1.level > n2.level ? 1 : -1) * (asc ? 1 : -1);
  }

  private static compareName(n1: Certification, n2: Certification, asc: boolean) : number {
    return (n1.name == n2.name ? 0 : n1.name > n2.name ? 1 : -1) * (asc ? 1 : -1);
  }
}
