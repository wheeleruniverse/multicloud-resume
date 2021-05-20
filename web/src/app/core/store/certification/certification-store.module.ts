import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {EffectsModule} from "@ngrx/effects";
import {CertificationEffects} from "./certification.effects";
import {StoreModule} from "@ngrx/store";
import {certificationReducer} from "./certification.reducer";

@NgModule({
  imports: [
    CommonModule,
    EffectsModule.forFeature([CertificationEffects]),
    StoreModule.forFeature('certification', certificationReducer)
  ]
})
export class CertificationStoreModule {}

