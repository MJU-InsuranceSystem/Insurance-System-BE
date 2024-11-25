package fourservings_fiveservings.insurance_system_be.team.plan.controller.dto.request;

import fourservings_fiveservings.insurance_system_be.team.plan.entity.InsurancePlan;
import fourservings_fiveservings.insurance_system_be.team.plan.entity.type.InsurancePlanType;
import fourservings_fiveservings.insurance_system_be.user.entity.Worker;
import org.springframework.web.multipart.MultipartFile;

public record CreatePlanRequestDto(
    String title,
    String description,
    String plannerName,
    String insurancePlanType,
    MultipartFile file
) {

    public InsurancePlan toEntity(Worker planner, String uploadedFileName) {
        return InsurancePlan.builder()
            .title(title)
            .description(description)
            .insurancePlanType(InsurancePlanType.findByName(insurancePlanType))
            .planner(planner)
            .fileName(uploadedFileName)
            .build();
    }
}
