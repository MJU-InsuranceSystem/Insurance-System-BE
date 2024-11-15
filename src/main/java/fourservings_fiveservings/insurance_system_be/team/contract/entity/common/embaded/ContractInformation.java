package fourservings_fiveservings.insurance_system_be.team.contract.entity.common.embaded;

import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.type.Bank;
import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.type.PaymentMethod;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author USER
 * @version 1.0
 */
@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContractInformation {

    private LocalDate startDate;

    private LocalDate endDate;

    private int paymentDate;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private String paymentAccount;

    @Enumerated(EnumType.STRING)
    private Bank bank;

//    private Insurance insurance;
}
