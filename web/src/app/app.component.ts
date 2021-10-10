import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {BreakpointObserver} from '@angular/cdk/layout';
import {environment} from '../environments/environment';
import {Device} from './shared/model/device.model';
import {IconRegistryService} from './shared/service/icon-registry.service';
import {ViewFacade} from './core/store/view/view.facade';
import {View} from './core/store/view/view.state';
import {Dictionary} from '@ngrx/entity';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit {
  constructor(
    private breakpointObserver: BreakpointObserver,
    private changeDetectorRef: ChangeDetectorRef,
    private iconRegistryService: IconRegistryService,
    private viewFacade: ViewFacade
  ) {
    iconRegistryService.init();
  }

  device: Device;
  view: Dictionary<View>;

  ngOnInit(): void {
    const mobileBreakPoint = '(max-width: 425px)';
    const tabletBreakPoint = '(max-width: 768px)';

    this.breakpointObserver.observe([mobileBreakPoint, tabletBreakPoint]).subscribe((result) => {
      if (result.breakpoints[mobileBreakPoint]) {
        this.device = Device.Mobile;
      }
      else if (result.breakpoints[tabletBreakPoint]) {
        this.device = Device.Tablet;
      }
      else {
        this.device = Device.Desktop;
      }
      this.closeView();
    });

    this.viewFacade.getAppView().subscribe((view => {
      this.view = view;
      this.changeDetectorRef.detectChanges();
    }));
  }

  get Device(): typeof Device {
    return Device;
  }

  get provider(): string {
    return environment.provider;
  }

  closeView(): void {
    if (!!this.view) {
      Object.keys(this.view).forEach((name) => this.viewFacade.setRender(name, false));
    }
  }

  toggleShouldRender(name: string): void {
    const target = this.view[name];
    if (target?.enable){
      this.viewFacade.setRender(name, !target.render);
    }
  }
}
