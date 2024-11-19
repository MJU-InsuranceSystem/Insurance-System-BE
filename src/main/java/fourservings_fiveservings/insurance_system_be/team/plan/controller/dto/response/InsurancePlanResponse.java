package fourservings_fiveservings.insurance_system_be.team.plan.controller.dto.response;

import fourservings_fiveservings.insurance_system_be.team.plan.entity.InsurancePlan;
import lombok.Builder;

@Builder
public record InsurancePlanResponse(
    String title,
    String description,
    String plannerName,
    String insurancePlanType,
    String fileUrl
) {

    public static InsurancePlanResponse of(InsurancePlan insurancePlan, String fileUrl) {
        return InsurancePlanResponse.builder()
            .title(insurancePlan.getTitle())
            .description(insurancePlan.getDescription())
            .plannerName(insurancePlan.getPlanner().getName())
            .insurancePlanType(insurancePlan.getInsurancePlanType().getName())
            .fileUrl(fileUrl)
            .build();
    }
}
