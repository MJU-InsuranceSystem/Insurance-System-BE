package fourservings_fiveservings.insurance_system_be.user.entity;

import fourservings_fiveservings.insurance_system_be.user.entity.embeded.Account;
import fourservings_fiveservings.insurance_system_be.user.entity.embeded.Address;
import fourservings_fiveservings.insurance_system_be.user.entity.enums.ContractStatus;
import fourservings_fiveservings.insurance_system_be.user.entity.enums.UserType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("CUSTOMER")
public class Customer extends User {

    @Embedded
    private Account account;

    @Enumerated(EnumType.STRING)
    private ContractStatus contractStatus;

    @Builder
    private Customer(String password, String email, String phoneNumber, Address address,
                     String name, String birthDay, UserType userType, ContractStatus contractStatus) {
        super(password, email, phoneNumber, address, name, birthDay, userType);
        this.contractStatus = ContractStatus.NONE;
    }
}
