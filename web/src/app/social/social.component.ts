import {Component} from '@angular/core';
import {faGithub, faLinkedinIn, faTwitter, IconDefinition} from '@fortawesome/free-brands-svg-icons';
import {faAt, faBlog, faCloud, faCoffee, faFilePdf, faUser} from '@fortawesome/free-solid-svg-icons';
import {getStorageUrl} from "../shared/utility/backend.utility";

@Component({
  selector: 'app-social',
  templateUrl: './social.component.html',
  styleUrls: ['./social.component.scss']
})
export class SocialComponent {

  get faAt(): IconDefinition {
    return faAt;
  }

  get faBlog(): IconDefinition {
    return faBlog;
  }

  get faCloud(): IconDefinition {
    return faCloud;
  }

  get faCoffee(): IconDefinition {
    return faCoffee;
  }

  get faFilePdf(): IconDefinition {
    return faFilePdf;
  }

  get faGithub(): IconDefinition {
    return faGithub;
  }

  get faLinkedinIn(): IconDefinition {
    return faLinkedinIn;
  }

  get faTwitter(): IconDefinition {
    return faTwitter;
  }

  get faUser(): IconDefinition {
    return faUser;
  }

  get storageUrlForResume(): string {
    return getStorageUrl('social', '0', 'resume.pdf');
  }
}
