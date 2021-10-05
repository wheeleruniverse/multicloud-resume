import {Component, Inject} from '@angular/core';
import {getStorageUrl} from '../../shared/utility/backend.utility';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';
import {Project} from '../../core/store/project/project.state';

@Component({
  templateUrl: './project-architecture-dialog.component.html',
  styleUrls: ['./project-architecture-dialog.component.scss'],
})
export class ProjectArchitectureDialogComponent {
  constructor(@Inject(MAT_DIALOG_DATA) public data: Project) {}

  index = 0;

  indexBack(): void {
    this.index--;
  }

  indexNext(): void {
    this.index++;
  }

  get storageUrlForIndex(): string {
    return getStorageUrl('project', this.data.id, `architecture/${this.index}.png`);
  }
}
