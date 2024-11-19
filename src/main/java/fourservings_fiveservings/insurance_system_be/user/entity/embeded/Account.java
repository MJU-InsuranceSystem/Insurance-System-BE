package fourservings_fiveservings.insurance_system_be.user.entity.embeded;


import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.type.Bank;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Bank bank;

    private String accountNumber;

    private int balance;
}
