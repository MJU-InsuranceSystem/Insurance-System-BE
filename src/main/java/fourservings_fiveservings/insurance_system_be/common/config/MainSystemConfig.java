package fourservings_fiveservings.insurance_system_be.common.config;

import fourservings_fiveservings.insurance_system_be.common.controller.FrontController;
import fourservings_fiveservings.insurance_system_be.common.view.InsuranceSystemView;
import fourservings_fiveservings.insurance_system_be.common.view.SystemView;
import fourservings_fiveservings.insurance_system_be.insurance.InsuranceListImpl;
import fourservings_fiveservings.insurance_system_be.insurance.apply.InsuranceApplyListImpl;
import fourservings_fiveservings.insurance_system_be.insurance.apply.InsuranceChargeCustomerApplyListImpl;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.model.AccidentListImpl;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.model.InsurancePremiumPaymentCustomerListImpl;
import fourservings_fiveservings.insurance_system_be.user.customer.CustomerProcessManager;
import fourservings_fiveservings.insurance_system_be.user.customer.CustomerSystem;
import fourservings_fiveservings.insurance_system_be.user.customer.CustomerView;
import fourservings_fiveservings.insurance_system_be.user.worker.WorkerSystem;

public class MainSystemConfig {

    public FrontController frontController() {
        return new FrontController(systemView(), customerSystem(),
            workerSystem());
    }

    private static SystemView systemView() {
        return new InsuranceSystemView();
    }

//    private AuthController authController() {
//        return new AuthController(systemView());
//    }


    private CustomerSystem customerSystem() {
        return new CustomerSystem(systemView(), customerView(), customerProcessManager(),
            new InsuranceListImpl());
    }

    private CustomerView customerView() {
        return new CustomerView();
    }

    private CustomerProcessManager customerProcessManager() {
        return new CustomerProcessManager(new InsuranceApplyListImpl(),
            new InsuranceChargeCustomerApplyListImpl(), new AccidentListImpl(),
            new InsurancePremiumPaymentCustomerListImpl() {
            });
    }

    private WorkerSystem workerSystem() {
        return new WorkerSystem(systemView());
    }

}
