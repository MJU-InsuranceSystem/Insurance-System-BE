package fourservings_fiveservings.insurance_system_be.team.payment.controller.dto.response;

import fourservings_fiveservings.insurance_system_be.team.payment.entity.Payment;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record PaymentListResponse(
    Long id,
    BigDecimal amount,
    LocalDateTime paymentDate,
    LocalDateTime dueDate,
    String paymentMethod
) {

    public static PaymentListResponse from(Payment payment) {
        return PaymentListResponse.builder()
            .id(payment.getId())
            .amount(payment.getAmount())
            .paymentDate(payment.getPaymentDate())
            .dueDate(payment.getDueDate())
            .paymentMethod(payment.getPaymentMethod().getDescription())
            .build();
    }
}
