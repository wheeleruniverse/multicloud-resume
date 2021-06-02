import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { AppComponent } from '../../../app.component';
import { EducationState } from '../../store/education/education.state';

@Injectable({
  providedIn: 'root',
})
export class EducationService {
  constructor(private httpClient: HttpClient) {}

  retrieve(): Observable<EducationState> {
    return this.httpClient.get<EducationState>(AppComponent.api.education.retrieve);
  }
}
