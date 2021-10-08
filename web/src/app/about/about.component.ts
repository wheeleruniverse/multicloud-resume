import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.scss'],
})
export class AboutComponent implements OnInit {

  index = 0;
  total = 2;
  count = Array(this.total).fill(0).map((x, i) => i);

  ngOnInit(): void {
    setInterval(() => {
      if (this.index < this.total - 1){
        this.index++;
      } else {
        this.index = 0;
      }
    }, 6000);
  }

  get photoUrlForIndex(): string {
    return `assets/about/photo/${this.index}.png`;
  }

  setIndex(value: number): void {
    this.index = value;
  }
}
