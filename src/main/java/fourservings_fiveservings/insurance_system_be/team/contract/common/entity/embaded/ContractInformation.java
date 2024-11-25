package fourservings_fiveservings.insurance_system_be.team.contract.common.entity.embaded;

import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.type.Bank;
import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.type.PaymentMethod;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContractInformation {

    private int paymentDate;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private String paymentAccount;

    @Enumerated(EnumType.STRING)
    private Bank bank;

    private LocalDate startDate;

    private LocalDate endDate;

//    private Insurance insurance;
}
