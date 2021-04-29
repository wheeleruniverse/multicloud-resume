import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  role = 'Cloud Architect';
  view = new Map<string, boolean>();

  ngOnInit(): void {
    this.view.set('education', false);
    this.view.set('experience', false);
    this.view.set('certifications', false);
    this.view.set('projects', false);
    this.view.set('skills', false);
  }

  toggleView(key: string): void {
    this.view.set(key, !this.view.get(key));
  }
}
