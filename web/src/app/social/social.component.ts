import {Component} from '@angular/core';
import {faGithub, faLinkedinIn, IconDefinition} from "@fortawesome/free-brands-svg-icons";
import {faBlog, faCloud, faUser} from "@fortawesome/free-solid-svg-icons";

@Component({
  selector: 'app-social',
  templateUrl: './social.component.html',
  styleUrls: ['./social.component.scss']
})
export class SocialComponent {

  get faBlog(): IconDefinition {
    return faBlog;
  }

  get faCloud(): IconDefinition {
    return faCloud;
  }

  get faGithub(): IconDefinition {
    return faGithub;
  }

  get faLinkedinIn(): IconDefinition {
    return faLinkedinIn;
  }

  get faUser(): IconDefinition {
    return faUser;
  }
}
