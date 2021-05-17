import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {AppComponent} from "../app.component";
import {VisitorCount} from "./visitor-count.model";
import {Visitor} from "./visitor.model";

@Injectable({
  providedIn: 'root'
})
export class VisitorService {

  constructor(private httpClient: HttpClient) {}

  count(): Observable<VisitorCount[]> {
    return this.httpClient.get<VisitorCount[]>(AppComponent.api.visitor.count);
  }

  create(visitor: Visitor): Observable<HttpResponse<object>> {
    return this.httpClient.post<HttpResponse<object>>(AppComponent.api.visitor.create, visitor, {observe : 'response'});
  }
}
