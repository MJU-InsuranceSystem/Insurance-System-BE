package fourservings_fiveservings.insurance_system_be.user.entity;

import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.type.Bank;
import fourservings_fiveservings.insurance_system_be.user.entity.embeded.Account;
import fourservings_fiveservings.insurance_system_be.user.entity.embeded.Address;
import fourservings_fiveservings.insurance_system_be.user.entity.enums.ContractStatus;
import fourservings_fiveservings.insurance_system_be.user.entity.enums.UserType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
        String name, String birthDay, UserType userType, Account account,
        ContractStatus contractStatus) {
        super(password, email, phoneNumber, address, name, birthDay, userType);
        this.contractStatus = ContractStatus.NONE;
        this.account = account;
    }

    public void addAccountInfo(Bank bank, String accountNumber, BigDecimal balance) {
        this.account = new Account(bank, accountNumber, balance);
    }

    public void payAmount(BigDecimal monthlyPayment) {
        this.account.withdraw(monthlyPayment);
    }
}
