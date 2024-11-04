package fourservings_fiveservings.insurance_system_be.team.customerManagement.view;

import fourservings_fiveservings.insurance_system_be.common.view.DepartmentView;
import fourservings_fiveservings.insurance_system_be.user.customer.Customer;
import java.util.List;

public class CustomerManagementView extends DepartmentView {

    public void showAllCustomerInfo(List<Customer> customers) {
        customers.forEach(customer -> {
            println("");
            println("고객 아이디 : " + customer.getId());
            println("고객 이름 : " + customer.getName());
            println("고객 나이 : " + customer.getAge());
            println("고객 성별 : " + customer.getSex());
            println("고객 전화번호 : " + customer.getPhoneNumber());
            println("");
        });
    }
}
