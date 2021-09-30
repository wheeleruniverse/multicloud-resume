import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AppComponent} from '../../../app.component';
import {Visitor} from '../../../visitor/visitor.model';
import {backend} from "../../../shared/utility/backend.utility";
import {VisitorState} from "../../store/visitor/visitor.state";

@Injectable({
  providedIn: 'root',
})
export class VisitorService {
  constructor(private httpClient: HttpClient) {}

  count(): Observable<VisitorState> {
    return this.httpClient.get<VisitorState>(backend.visitor.count);
  }

  increment(): Observable<HttpResponse<object>> {
    return this.httpClient.post<HttpResponse<object>>(backend.visitor.increment, null, {
      observe: 'response',
    });
  }
}
