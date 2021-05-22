import {NgModule} from '@angular/core';
import {StoreModule} from '@ngrx/store';
import {EffectsModule} from "@ngrx/effects";
import {environment} from "../../environments/environment";
import {StoreDevtoolsModule} from "@ngrx/store-devtools";
import {CertificationEffects} from "./store/certification/certification.effects";
import {certificationReducer} from "./store/certification/certification.reducer";
import {EducationEffects} from "./store/education/education.effects";
import {educationReducer} from "./store/education/education.reducer";


@NgModule({
  imports: [
    EffectsModule.forRoot([
      CertificationEffects,
      EducationEffects
    ]),
    StoreModule.forRoot({
      'certification': certificationReducer,
      'education': educationReducer
    }),
    !environment.production ? StoreDevtoolsModule.instrument() : []
  ]
})
export class CoreModule {}
