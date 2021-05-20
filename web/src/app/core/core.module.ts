import {NgModule} from '@angular/core';
import { StoreModule } from '@ngrx/store';
import * as fromState from './store/app.state';
import {CertificationStoreModule} from "./store/certification/certification-store.module";
import {EffectsModule} from "@ngrx/effects";
import {environment} from "../../environments/environment";
import {StoreDevtoolsModule} from "@ngrx/store-devtools";


@NgModule({
  imports: [
    CertificationStoreModule,
    EffectsModule.forRoot([]),
    StoreModule.forRoot({}),
    !environment.production ? StoreDevtoolsModule.instrument() : []
  ]
})
export class CoreModule {}
