import {Component, OnInit} from '@angular/core';
import {VisitorFacade} from '../core/store/visitor/visitor.facade';
import {ViewFacade} from '../core/store/view/view.facade';

@Component({
  selector: 'app-visitor',
  templateUrl: './visitor.component.html',
  styleUrls: ['./visitor.component.scss'],
})
export class VisitorComponent implements OnInit {
  constructor(
    private viewFacade: ViewFacade,
    private visitorFacade: VisitorFacade,
  ) {}

  total: number;

  ngOnInit(): void {
    this.viewFacade.setEnable('visitor', false);

    this.visitorFacade.count().subscribe((total) => {
      this.total = total;
      this.viewFacade.setEnable('visitor', true);
    });
  }

  totalCharAt(position: number): string {
    if (!this.total){
      return '0';
    }
    const value = ('0000000' + this.total).slice(-7);
    return position > value.length - 1 ? '0' : value.charAt(position);
  }
}
