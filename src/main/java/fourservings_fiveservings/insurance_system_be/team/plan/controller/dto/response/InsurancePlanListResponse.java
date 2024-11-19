package fourservings_fiveservings.insurance_system_be.team.plan.controller.dto.response;

import fourservings_fiveservings.insurance_system_be.team.plan.entity.InsurancePlan;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public record InsurancePlanListResponse(
    Long id,
    String title,
    String insuranceType,
    String plannerName,
    String description
) {

    public static InsurancePlanListResponse from(InsurancePlan insurancePlan) {
        return InsurancePlanListResponse.builder()
            .id(insurancePlan.getId())
            .title(insurancePlan.getTitle())
            .insuranceType(insurancePlan.getInsuranceType().getName())
            .plannerName(insurancePlan.getWorker().getName())
            .description(insurancePlan.getDescription())
            .build();
    }
}
