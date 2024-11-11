package fourservings_fiveservings.insurance_system_be.user.entity;

import fourservings_fiveservings.insurance_system_be.user.entity.embeded.ContractStatus;
import fourservings_fiveservings.insurance_system_be.user.entity.embeded.Address;
import fourservings_fiveservings.insurance_system_be.user.entity.embeded.UserType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("CUSTOMER")
public class Customer extends User {

    @Enumerated(EnumType.STRING)
    private ContractStatus contractStatus;

    @Builder
    private Customer(String password, String email, String phoneNumber, Address address,
                     String name, String birthDay, UserType userType, ContractStatus contractStatus) {
        super(password, email, phoneNumber, address, name, birthDay, userType);
        this.contractStatus = ContractStatus.NONE;
    }
}
