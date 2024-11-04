package fourservings_fiveservings.insurance_system_be.user.auth;


import fourservings_fiveservings.insurance_system_be.common.view.SystemView;
import fourservings_fiveservings.insurance_system_be.user.User;

public class AuthController {

    private final SystemView systemView;

    public AuthController(SystemView systemView) {
        this.systemView = systemView;
    }

    public User process() {
        int selectNumber = systemView.selectAuthOption();
        if (selectNumber == 3) {
            systemView.exitSystem();
            return null;
        }
        Process process = AuthProcessType.findProcessType(selectNumber).getProcess();
        return process.execute(systemView);
    }
}
