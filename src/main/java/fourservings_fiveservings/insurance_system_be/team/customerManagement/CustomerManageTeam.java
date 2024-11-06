package fourservings_fiveservings.insurance_system_be.team.customerManagement;

import fourservings_fiveservings.insurance_system_be.user.entity.Customer;
import fourservings_fiveservings.insurance_system_be.user.customer.CustomerList;
import java.util.List;

/**
 * @author USER
 * @version 1.0
 */
public class CustomerManageTeam {

    private final CustomerList customerList = CustomerList.getInstance();

    public void manage() {

    }

    public void process() {

    }

    public void register() {

    }

    public void remove() {

    }

    public List<Customer> retrieveCustomerInfo() {
        return customerList.getCustomerList();
    }
}