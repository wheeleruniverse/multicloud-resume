import {Component, OnInit} from '@angular/core';
import {VisitorService} from "./visitor.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {skipUntil, switchMap} from "rxjs/operators";

@Component({
  selector: 'app-visitor',
  templateUrl: './visitor.component.html',
  styleUrls: ['./visitor.component.scss']
})
export class VisitorComponent implements OnInit {

  constructor(private service: VisitorService, private _snackBar: MatSnackBar) {}

  total: number;

  ngOnInit(): void {
    const config = {duration: 3000};
    const visitor = {name: window.navigator.userAgent};

    this.service.create(visitor).subscribe((res) => {
      this.initTotal();
      if(res.status == 201){
        this._snackBar.open('Visitor Created!', null, config);
        this.total += 1;
      } else {
        this._snackBar.open('Visitor Failure!', null, config);
      }
    });

    this.service.count().subscribe(count => {
      this.initTotal();
      count.forEach(c => {
        this.total += c.cnt;
      });
    });
  }

  private initTotal(){
    if(this.total == null){
      this.total = 0;
    }
  }
}
