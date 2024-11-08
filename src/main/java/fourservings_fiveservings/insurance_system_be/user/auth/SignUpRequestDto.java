package fourservings_fiveservings.insurance_system_be.user.auth;

import fourservings_fiveservings.insurance_system_be.user.Address;
import fourservings_fiveservings.insurance_system_be.user.User;
import fourservings_fiveservings.insurance_system_be.user.customer.Customer;

public record SignUpRequestDto(
    String loginId,

    String password,

    String email,

    String phoneNumber,

    String country,

    String city,

    String zipCode,

    String name,

    String birthDay
) {

    public User toEntity(String encodedPassword) {
        return Customer.builder()
            .loginId(loginId)
            .password(encodedPassword)
            .email(email)
            .phoneNumber(phoneNumber)
            .address(new Address(country, city, zipCode))
            .name(name)
            .birthDay(birthDay)
            .build();
    }
}
