package fourservings_fiveservings.insurance_system_be.team.customerManagement.controller;


import fourservings_fiveservings.insurance_system_be.team.TeamController;
import fourservings_fiveservings.insurance_system_be.team.customerManagement.CustomerManageTeam;
import fourservings_fiveservings.insurance_system_be.team.customerManagement.usecase.CustomerManagementUsecase;
import fourservings_fiveservings.insurance_system_be.team.customerManagement.view.CustomerManagementView;

public class CustomerManagementController implements TeamController {

    private final CustomerManageTeam customerManageTeam;
    private final CustomerManagementView customerManagementView;

    public CustomerManagementController(CustomerManageTeam customerManageTeam,
        CustomerManagementView customerManagementView) {
        this.customerManageTeam = customerManageTeam;
        this.customerManagementView = customerManagementView;
    }

    @Override
    public void process() {
        customerManagementView.intro("고객 관리 팀");
        int selectNumber = customerManagementView.selectUsecase(CustomerManagementUsecase.class);
        CustomerManagementUsecase usecase = CustomerManagementUsecase.findByNumber(selectNumber);
        executeUsecase(usecase);
    }

    private void executeUsecase(CustomerManagementUsecase usecase) {
        switch (usecase) {
            case ALL_CUSTOMER_RETRIEVE -> {
                customerManagementView.showAllCustomerInfo(
                    customerManageTeam.retrieveCustomerInfo());
            }
            default -> throw new IllegalArgumentException("해당하는 usecase가 없습니다.");
        }
    }
}
