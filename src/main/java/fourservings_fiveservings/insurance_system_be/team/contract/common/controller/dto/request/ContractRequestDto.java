package fourservings_fiveservings.insurance_system_be.team.contract.common.controller.dto.request;

import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.embaded.ContractInformation;
import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.type.Bank;
import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.type.PaymentMethod;
import java.time.LocalDate;

public record ContractRequestDto(
    int paymentDate,
    String paymentMethod,
    String paymentAccount,
    String bank,
    LocalDate startDate,
    LocalDate endDate
) {

    public ContractInformation toContractInformation() {
        return ContractInformation.builder()
            .startDate(this.startDate)
            .endDate(this.endDate)
            .paymentDate(this.paymentDate)
            .paymentMethod(PaymentMethod.findByDescription(this.paymentMethod))
            .paymentAccount(this.paymentAccount)
            .bank(Bank.fromName(this.bank))
            .build();
    }
}
