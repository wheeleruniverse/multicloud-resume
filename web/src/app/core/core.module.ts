import { NgModule } from '@angular/core';
import { StoreModule } from '@ngrx/store';
import { EffectsModule } from '@ngrx/effects';
import { environment } from '../../environments/environment';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';
import { CertificationEffects } from './store/certification/certification.effects';
import { certificationReducer } from './store/certification/certification.reducer';
import { EducationEffects } from './store/education/education.effects';
import { educationReducer } from './store/education/education.reducer';
import { ExperienceEffects } from './store/experience/experience.effects';
import { experienceReducer } from './store/experience/experience.reducer';
import { projectReducer } from './store/project/project.reducer';
import { ProjectEffects } from './store/project/project.effects';
import { SkillEffects } from './store/skill/skill.effects';
import { skillReducer } from './store/skill/skill.reducer';
import { VisitorEffects } from './store/visitor/visitor.effects';
import { visitorReducer } from './store/visitor/visitor.reducer';
import { ViewEffects } from './store/view/view.effects';
import { viewReducer } from './store/view/view.reducer';

@NgModule({
  imports: [
    EffectsModule.forRoot([
      CertificationEffects,
      EducationEffects,
      ExperienceEffects,
      ProjectEffects,
      SkillEffects,
      ViewEffects,
      VisitorEffects,
    ]),
    StoreModule.forRoot({
      certification: certificationReducer,
      education: educationReducer,
      experience: experienceReducer,
      project: projectReducer,
      skill: skillReducer,
      view: viewReducer,
      visitor: visitorReducer
    }),
    !environment.production ? StoreDevtoolsModule.instrument() : [],
  ],
})
export class CoreModule {}
