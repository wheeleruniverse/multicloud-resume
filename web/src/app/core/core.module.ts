import {NgModule} from '@angular/core';
import {StoreModule} from '@ngrx/store';
import {EffectsModule} from "@ngrx/effects";
import {environment} from "../../environments/environment";
import {StoreDevtoolsModule} from "@ngrx/store-devtools";
import {CertificationEffects} from "./store/certification/certification.effects";
import {certificationReducer} from "./store/certification/certification.reducer";


@NgModule({
  imports: [
    // CertificationStoreModule,
    EffectsModule.forRoot([CertificationEffects]),
    StoreModule.forRoot({
      'certification': certificationReducer
    }),
    !environment.production ? StoreDevtoolsModule.instrument() : []
  ]
})
export class CoreModule {}
