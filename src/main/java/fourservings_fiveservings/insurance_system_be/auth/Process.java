package fourservings_fiveservings.insurance_system_be.auth;

import fourservings_fiveservings.insurance_system_be.common.view.SystemView;
import fourservings_fiveservings.insurance_system_be.user.entity.User;

public interface Process {

    User execute(SystemView systemView);
}
