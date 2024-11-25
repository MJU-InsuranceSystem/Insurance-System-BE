package fourservings_fiveservings.insurance_system_be.team.reward.claim.controller.dto.response;

import fourservings_fiveservings.insurance_system_be.team.reward.claim.entity.Claim;
import java.math.BigDecimal;
import lombok.Builder;

@Builder
public record ClaimListResponse(
    Long id,
    String accidentTitle,
    String payerName,
    BigDecimal paymentAmount,
    String comments
) {

    public static ClaimListResponse from(Claim claim) {
        return ClaimListResponse.builder()
            .id(claim.getId())
            .accidentTitle(claim.getAccident().getTitle())
            .payerName(claim.getWorker().getName())
            .paymentAmount(claim.getPaymentAmount())
            .comments(claim.getComments())
            .build();
    }
}
