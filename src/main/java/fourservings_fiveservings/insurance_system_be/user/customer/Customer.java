package fourservings_fiveservings.insurance_system_be.user.customer;

import fourservings_fiveservings.insurance_system_be.user.User;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@DiscriminatorValue("CUSTOMER")
@SuperBuilder
public class Customer extends User {

    private ContractStatus contractStatus;
}
