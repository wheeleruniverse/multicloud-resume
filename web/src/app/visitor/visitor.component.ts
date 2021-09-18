import { Component, OnInit } from '@angular/core';
import { VisitorService } from '../core/service/visitor/visitor.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CookieService } from 'ngx-cookie-service';
import { v4 } from 'uuid';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-visitor',
  templateUrl: './visitor.component.html',
  styleUrls: ['./visitor.component.scss'],
})
export class VisitorComponent implements OnInit {
  constructor(
    private cookieService: CookieService,
    private service: VisitorService,
    private snackBar: MatSnackBar) {}

  private readonly cookie = `${environment.provider}-visitor`;
  total: number;

  ngOnInit(): void {
    this.service.count().subscribe((total) => {
      this.total = total;
    });
    if (!this.cookieService.check(this.cookie)) {
      this.createVisitor();
    }
  }

  private createVisitor(): void {
    const config = { duration: 3000 };
    const visitor = { id: v4(), name: window.navigator.userAgent };

    this.service.create(visitor).subscribe((res) => {
      if ([200, 201, 204].includes(res.status)) {
        this.cookieService.set(this.cookie, visitor.id, 30);
        this.snackBar.open('Visitor Created!', null, config);
        this.total = !!this.total ? this.total + 1 : 1;
      } else {
        this.snackBar.open('Visitor Failure!', null, config);
      }
    });
  }
}
