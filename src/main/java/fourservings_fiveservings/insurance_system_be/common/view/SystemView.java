package fourservings_fiveservings.insurance_system_be.common.view;

import java.util.Map;

public interface SystemView {

    void introduce();

    int selectAuthOption();

    Map<String, String> getLoginInfo();

    Map<String, String> getSignUpInfo();

    void successLogin();

    void successSignUp();

    void exitSystem();

    int selectTeam();

    int selectCustomerProcess();

    void showError(String message);
}
