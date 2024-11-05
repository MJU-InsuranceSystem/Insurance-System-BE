package fourservings_fiveservings.insurance_system_be.user;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    private String country;

    private String city;

    private String zipCode;
}
