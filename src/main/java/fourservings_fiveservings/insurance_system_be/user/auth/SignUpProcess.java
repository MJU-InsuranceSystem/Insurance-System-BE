package fourservings_fiveservings.insurance_system_be.user.auth;

import fourservings_fiveservings.insurance_system_be.common.view.SystemView;
import fourservings_fiveservings.insurance_system_be.user.User;
import fourservings_fiveservings.insurance_system_be.user.UserType;
import fourservings_fiveservings.insurance_system_be.user.customer.Customer;
import fourservings_fiveservings.insurance_system_be.user.customer.CustomerList;
import fourservings_fiveservings.insurance_system_be.user.worker.Worker;
import fourservings_fiveservings.insurance_system_be.user.worker.WorkerList;
import java.util.Map;

public class SignUpProcess implements Process {

    private final CustomerList customerList;
    private final WorkerList workerList;

    public SignUpProcess(CustomerList customerList, WorkerList workerList) {
        this.customerList = customerList;
        this.workerList = workerList;
    }

    @Override
    public User execute(SystemView systemView) {
        Map<String, String> signUpInfo = systemView.getSignUpInfo();
        User user = signUp(signUpInfo);
        systemView.successSignUp();
        return user;
    }

    private User signUp(Map<String, String> signUpInfo) {
        UserType userType = UserType.find(
            signUpInfo.get(AuthGuideMessage.AUTH_CUSTOMER_WORKER_KEY));
        switch (userType) {
            case CUSTOMER -> {
//                Customer customer = new Customer();
//                customerList.add(customer);
//                return customer;
                return null;

            }
            case WORKER -> {
//                Worker worker = Worker.create(signUpInfo);
//                workerList.add(worker);
//                return worker;
                return null;
            }
            default -> {
                throw new IllegalArgumentException("지원하지 않는 유형입니다");
            }
        }
    }
}
