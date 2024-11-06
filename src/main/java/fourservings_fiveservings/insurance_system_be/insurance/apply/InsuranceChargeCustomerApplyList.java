package fourservings_fiveservings.insurance_system_be.insurance.apply;


import fourservings_fiveservings.insurance_system_be.user.entity.Customer;

public interface InsuranceChargeCustomerApplyList {

    void add(Customer customer);

    void remove(Customer customer);

    void remove(int index);

    Customer findById(int insuranceId);

    Customer findFirst();

    void update(Customer insurance);

    boolean isEmpty();
}
