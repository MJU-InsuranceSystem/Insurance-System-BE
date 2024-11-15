package fourservings_fiveservings.insurance_system_be.team.contract.controller.dto.request;

import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.embaded.ContractInformation;
import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.type.Bank;
import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.type.PaymentMethod;
import java.time.LocalDate;

public record ContractRequestDto(
    int paymentDate,
    PaymentMethod paymentMethod,
    String paymentAccount,
    Bank bank,
    LocalDate startDate,
    LocalDate endDate
) {

    public ContractInformation toContractInformation() {
        return ContractInformation.builder()
            .startDate(this.startDate)
            .endDate(this.endDate)
            .paymentDate(this.paymentDate)
            .paymentMethod(this.paymentMethod)
            .paymentAccount(this.paymentAccount)
            .bank(this.bank)
            .build();
    }
}