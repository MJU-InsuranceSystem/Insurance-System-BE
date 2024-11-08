package fourservings_fiveservings.insurance_system_be.team.rewardSupport.model;


import fourservings_fiveservings.insurance_system_be.domain.user.entity.Customer;
import java.util.List;

public interface InsurancePremiumPaymentCustomerList {

    public void add(Customer customer);

    public void delete(Customer customer);

    List<Customer> getAll();

    boolean contains(Customer customer);
}
