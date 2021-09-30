import {Component, OnInit} from '@angular/core';
import {ViewService} from "../shared/service/view.service";
import {VisitorFacade} from "../core/store/visitor/visitor.facade";

@Component({
  selector: 'app-visitor',
  templateUrl: './visitor.component.html',
  styleUrls: ['./visitor.component.scss'],
})
export class VisitorComponent implements OnInit {
  constructor(
    private viewService: ViewService,
    private visitorFacade: VisitorFacade,
  ) {}

  total: number;

  ngOnInit(): void {
    this.viewService.visitorShouldEnable(false);

    this.visitorFacade.count().subscribe((total) => {
      this.total = total;
      this.viewService.visitorShouldEnable(true);
    });
  }

  totalCharAt(position: number): string {
    if(!this.total){
      return '0';
    }
    const value = ('0000000' + this.total).slice(-7);
    return position > value.length - 1 ? '0' : value.charAt(position);
  }
}
