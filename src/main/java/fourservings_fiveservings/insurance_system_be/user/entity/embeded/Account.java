package fourservings_fiveservings.insurance_system_be.user.entity.embeded;


import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.common.type.Bank;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Enumerated(EnumType.STRING)
    private Bank bank;

    private String accountNumber;

    private BigDecimal balance;

    public void withdraw(BigDecimal monthlyPayment) {
        this.balance = this.balance.subtract(monthlyPayment);
    }
}
