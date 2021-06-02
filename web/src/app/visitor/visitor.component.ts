import { Component, OnInit } from '@angular/core';
import { VisitorService } from '../core/service/visitor/visitor.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CookieService } from 'ngx-cookie-service';
import { v4 } from 'uuid';

@Component({
  selector: 'app-visitor',
  templateUrl: './visitor.component.html',
  styleUrls: ['./visitor.component.scss'],
})
export class VisitorComponent implements OnInit {
  constructor(private cookieService: CookieService, private service: VisitorService, private snackBar: MatSnackBar) {}

  total: number;

  ngOnInit(): void {
    this.service.count().subscribe((count) => {
      this.initTotal();
      count.forEach((c) => {
        this.total += c.cnt;
      });
    });

    if (!this.cookieService.check('Visitor')) {
      this.createVisitor();
    }
  }

  private createVisitor(): void {
    const config = { duration: 3000 };
    const visitor = { id: v4(), name: window.navigator.userAgent };

    this.service.create(visitor).subscribe((res) => {
      this.initTotal();
      if (res.status === 201) {
        this.cookieService.set('Visitor', visitor.id, 30);
        this.snackBar.open('Visitor Created!', null, config);
        this.total += 1;
      } else {
        this.snackBar.open('Visitor Failure!', null, config);
      }
    });
  }

  private initTotal(): void {
    if (this.total == null) {
      this.total = 0;
    }
  }
}
