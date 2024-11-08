package fourservings_fiveservings.insurance_system_be.team.rewardSupport.model;

import fourservings_fiveservings.insurance_system_be.domain.user.entity.Customer;
import java.util.ArrayList;
import java.util.List;

public class InsurancePremiumPaymentCustomerListImpl implements
    InsurancePremiumPaymentCustomerList {

    private static final List<Customer> customerList = new ArrayList<>();

    @Override
    public void add(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerList.remove(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerList;
    }

    @Override
    public boolean contains(Customer customer) {
        return customerList.contains(customer);
    }
}
