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

  @Input() cellsToShow: number = 3;
  @Input() height: number = 400;
  @Input() width: number = 1400;

  arrows = true;


  ngOnInit(): void {
    this.breakpointObserver.observe('(max-width: 425px)')
      .pipe(filter(result => result.matches))
      .subscribe(() => {
        this.arrows = false;
        this.cellsToShow = 1;
        this.width = 250;
      });
  }
}
