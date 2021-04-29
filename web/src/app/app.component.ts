import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  role = 'Cloud Architect';
  showExperience: boolean = false;

  toggleExperience(): void {
    this.showExperience = !this.showExperience;
  }
}
