package fourservings_fiveservings.insurance_system_be.team.payment.controller.dto.request;

import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.Contract;
import fourservings_fiveservings.insurance_system_be.team.payment.entity.Payment;
import fourservings_fiveservings.insurance_system_be.team.payment.entity.enums.PaymentMethod;

import java.time.LocalDateTime;

public record PayRequestDto(
        int amount,

        LocalDateTime paymentDate,

        LocalDateTime dueDate,

        PaymentMethod paymentMethod
) {

    public Payment toPayment(Contract contract) {
        return Payment.builder()
                .amount(amount)
                .paymentDate(paymentDate)
                .dueDate(dueDate)
                .paymentMethod(paymentMethod)
                .contract(contract)
                .build();
    }
}
