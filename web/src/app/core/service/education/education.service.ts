import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { AppComponent } from '../../../app.component';
import { EducationState } from '../../store/education/education.state';
import {backend} from "../../../shared/utility/backend.utility";

@Injectable({
  providedIn: 'root',
})
export class EducationService {
  constructor(private httpClient: HttpClient) {}

  retrieve(): Observable<EducationState> {
    return this.httpClient.get<EducationState>(backend.education.retrieve);
  }
}
