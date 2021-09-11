import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AppComponent} from '../../../app.component';
import {Visitor} from '../../../visitor/visitor.model';

@Injectable({
  providedIn: 'root',
})
export class VisitorService {
  constructor(private httpClient: HttpClient) {}

  count(): Observable<number> {
    return this.httpClient.get<number>(AppComponent.api.visitor.count);
  }

  create(visitor: Visitor): Observable<HttpResponse<object>> {
    return this.httpClient.post<HttpResponse<object>>(AppComponent.api.visitor.create, visitor, {
      observe: 'response',
    });
  }
}
