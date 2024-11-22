package fourservings_fiveservings.insurance_system_be.team.insurance.controller.dto.response;

import fourservings_fiveservings.insurance_system_be.team.insurance.entity.Insurance;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Builder;

@Builder
public record InsuranceResponse(
    Long id,

    String name,

    String description,

    int eligibleAgeMin,

    int eligibleAgeMax,

    String coverageRange,

    BigDecimal coverageAmountMax,

    int duration,

    String exclusions,

    BigDecimal monthlyPremium,

    LocalDate salesStartDate,

    LocalDate salesEndDate,

    String saleTarget,

    String insuranceType,

    String workerName // Worker 엔티티와 연관된 담당자의 이름
) {

    public static InsuranceResponse from(Insurance insurance) {
        return InsuranceResponse.builder()
            .id(insurance.getId())
            .name(insurance.getName())
            .description(insurance.getDescription())
            .eligibleAgeMin(insurance.getEligibleAgeMin())
            .eligibleAgeMax(insurance.getEligibleAgeMax())
            .coverageRange(insurance.getCoverageRange())
            .coverageAmountMax(insurance.getCoverageAmountMax())
            .duration(insurance.getDuration())
            .exclusions(insurance.getExclusions())
            .monthlyPremium(insurance.getMonthlyPremium())
            .salesStartDate(insurance.getSalesStartDate())
            .salesEndDate(insurance.getSalesEndDate())
            .saleTarget(insurance.getSaleTarget().getDescription())
            .insuranceType(insurance.getInsuranceType().getName())
            .workerName(insurance.getWorker().getName())
            .build();
    }
}
