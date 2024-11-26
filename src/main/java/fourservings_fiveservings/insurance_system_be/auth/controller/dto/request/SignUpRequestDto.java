package fourservings_fiveservings.insurance_system_be.auth.controller.dto.request;

import fourservings_fiveservings.insurance_system_be.user.entity.type.Role;
import fourservings_fiveservings.insurance_system_be.user.entity.type.UserType;
import fourservings_fiveservings.insurance_system_be.user.entity.embeded.Address;
import fourservings_fiveservings.insurance_system_be.user.entity.Customer;
import fourservings_fiveservings.insurance_system_be.user.entity.User;
import fourservings_fiveservings.insurance_system_be.user.entity.Worker;

public record SignUpRequestDto(

        String password,

        String email,

        String phoneNumber,

        String country,

        String city,

        String zipCode,

        String name,

        String birthDay,

        UserType userType,

        int hireYear,

        String role
) {
    public User toCustomer(String encodedPassword) {
        return Customer.builder()
                .password(encodedPassword)
                .email(email)
                .phoneNumber(phoneNumber)
                .address(new Address(country, city, zipCode))
                .name(name)
                .birthDay(birthDay)
                .userType(userType)
                .build();
    }

    public User toWorker(String encodedPassword) {
        return Worker.builder()
                .password(encodedPassword)
                .email(email)
                .phoneNumber(phoneNumber)
                .address(new Address(country, city, zipCode))
                .name(name)
                .birthDay(birthDay)
                .userType(userType)
                .hireYear(hireYear)
                .role(Role.findByName(role))
                .build();
    }
}
