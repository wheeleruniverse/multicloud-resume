import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AppComponent} from '../../../app.component';
import {Visitor} from '../../../visitor/visitor.model';
import {backend} from "../../../shared/utility/backend.utility";

@Injectable({
  providedIn: 'root',
})
export class VisitorService {
  constructor(private httpClient: HttpClient) {}

  count(): Observable<number> {
    return this.httpClient.get<number>(backend.visitor.count);
  }

  create(visitor: Visitor): Observable<HttpResponse<object>> {
    return this.httpClient.post<HttpResponse<object>>(backend.visitor.create, visitor, {
      observe: 'response',
    });
  }
}
