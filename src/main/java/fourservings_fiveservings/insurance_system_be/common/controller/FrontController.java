package fourservings_fiveservings.insurance_system_be.common.controller;


import fourservings_fiveservings.insurance_system_be.common.view.SystemView;
import fourservings_fiveservings.insurance_system_be.user.User;
import fourservings_fiveservings.insurance_system_be.user.auth.AuthController;
import fourservings_fiveservings.insurance_system_be.user.customer.CustomerSystem;
import fourservings_fiveservings.insurance_system_be.user.worker.WorkerSystem;

public class FrontController {

    private final SystemView systemView;
    private final AuthController authController;
    private final CustomerSystem customerSystem;
    private final WorkerSystem workerSystem;

    private static boolean PROGRAM_TRIGGER = false;

    public FrontController(SystemView systemView, AuthController authController,
        CustomerSystem customerSystem, WorkerSystem workerSystem) {
        this.systemView = systemView;
        this.authController = authController;
        this.customerSystem = customerSystem;
        this.workerSystem = workerSystem;
    }

    public void run() {
        systemView.introduce();
        while (!PROGRAM_TRIGGER) {
            try {
                User user = authController.process();
                if (user == null) {
                    break;
                }
//                if (!user.isLogin()) {
//                    continue;
//                }
                switch (user.getUserType()) {
                    case CUSTOMER -> customerSystem.process();
                    case WORKER -> workerSystem.process();
                    default -> throw new IllegalArgumentException("올바른 유저 유형을 찾을 수 없습니다.");
                }
            } catch (Exception e) {
                systemView.showError(e.getMessage());
            }
        }
    }
}

