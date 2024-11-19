package fourservings_fiveservings.insurance_system_be.team.insurance.controller.dto.response;

import fourservings_fiveservings.insurance_system_be.team.insurance.entity.Insurance;
import java.math.BigDecimal;
import lombok.Builder;

@Builder
public record InsuranceListResponse(
    Long id,
    String name,
    String description,
    String insuranceType,
    String saleTarget,
    BigDecimal monthlyPremium,
    int eligibleAgeMin,
    int eligibleAgeMax
) {

    public static InsuranceListResponse from(Insurance insurance) {
        return InsuranceListResponse.builder()
            .id(insurance.getId())
            .name(insurance.getName())
            .description(insurance.getDescription())
            .insuranceType(insurance.getInsuranceType().getName())
            .saleTarget(insurance.getSaleTarget().getDescription())
            .monthlyPremium(insurance.getMonthlyPremium())
            .eligibleAgeMin(insurance.getEligibleAgeMin())
            .eligibleAgeMax(insurance.getEligibleAgeMax())
            .build();
    }
}
