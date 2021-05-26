import {Component, Input, OnInit} from '@angular/core';
import {BreakpointObserver} from "@angular/cdk/layout";
import {filter} from "rxjs/operators";


@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.scss']
})
export class CarouselComponent implements OnInit {

  constructor(private breakpointObserver: BreakpointObserver) {}

  @Input() cellsToShow: number;
  @Input() height: number;

  arrows = true;
  autoplay = false;
  cellWidth: number;
  width = 1400;

  ngOnInit(): void {
    this.cellWidth = this.width / this.cellsToShow;

    this.breakpointObserver.observe('(max-width: 425px)')
      .pipe(filter(result => result.matches))
      .subscribe(() => {
        this.arrows = false;
        this.autoplay = true;
        this.cellsToShow = 1;
        this.cellWidth = 280;
        this.width = 280;
      });
  }
}
