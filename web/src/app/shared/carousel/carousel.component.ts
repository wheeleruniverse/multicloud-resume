import {ChangeDetectorRef, Component, Input, OnInit} from '@angular/core';
import {BreakpointObserver} from "@angular/cdk/layout";
import {filter} from "rxjs/operators";


@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.scss']
})
export class CarouselComponent implements OnInit {

  constructor(private breakpointObserver: BreakpointObserver) {}

  @Input() arrows = true;
  @Input() cellsToShow: number;
  @Input() height: number;

  carouselArrows: boolean;
  carouselAutoplay: boolean;
  carouselCellWidth: number;
  carouselCellsToShow: number;
  carouselHeight: number;
  carouselWidth: number;

  ngOnInit(): void {
    this.setDesktopView();

    const mobileBreakPoint = '(max-width: 425px)';
    const tabletBreakPoint = '(max-width: 768px)';

    this.breakpointObserver
      .observe([
        mobileBreakPoint,
        tabletBreakPoint,
      ])
      .subscribe((result) => {
        if(result.breakpoints[mobileBreakPoint]){
          this.setMobileView();
        }
        else if(result.breakpoints[tabletBreakPoint]){
          this.setTabletView();
        }
        else {
          this.setDesktopView();
        }
      });
  }

  private setDesktopView(): void {
    this.carouselArrows = this.arrows;
    this.carouselAutoplay = false;
    this.carouselCellsToShow = this.cellsToShow;
    this.carouselHeight = this.height;
    this.carouselWidth = 1400;
    this.carouselCellWidth = this.carouselWidth / this.carouselCellsToShow;
  }

  private setMobileView(): void {
    this.carouselArrows = false;
    this.carouselAutoplay = true;
    this.carouselCellsToShow = 1;
    this.carouselHeight = this.height * 1.25;
    this.carouselWidth = 270;
    this.carouselCellWidth = this.carouselWidth / this.carouselCellsToShow;
  }

  private setTabletView(): void {
    this.carouselArrows = true;
    this.carouselAutoplay = false;
    this.carouselCellsToShow = 1;
    this.carouselHeight = this.height;
    this.carouselWidth = 600;
    this.carouselCellWidth = this.carouselWidth / this.carouselCellsToShow;
  }
}
