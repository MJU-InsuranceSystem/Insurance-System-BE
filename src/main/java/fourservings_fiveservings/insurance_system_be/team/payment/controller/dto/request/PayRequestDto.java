package fourservings_fiveservings.insurance_system_be.team.payment.controller.dto.request;

import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.Contract;
import fourservings_fiveservings.insurance_system_be.team.payment.entity.Payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PayRequestDto(
        BigDecimal amount,

        LocalDateTime paymentDate,

        LocalDateTime dueDate
) {

    public Payment toPayment(Contract contract) {
        return Payment.builder()
                .amount(amount)
                .paymentDate(paymentDate)
                .dueDate(dueDate)
                .paymentMethod(contract.getContractInformation().getPaymentMethod())
                .contract(contract)
                .build();
    }
}
