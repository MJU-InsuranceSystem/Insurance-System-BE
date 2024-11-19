package fourservings_fiveservings.insurance_system_be.team.plan.service;

import fourservings_fiveservings.insurance_system_be.team.plan.controller.dto.CreatePlanRequestDto;
import fourservings_fiveservings.insurance_system_be.team.plan.entity.InsurancePlan;
import fourservings_fiveservings.insurance_system_be.team.plan.service.implement.InsurancePlanFinder;
import fourservings_fiveservings.insurance_system_be.user.entity.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InsurancePlanService {

    private final InsurancePlanFinder insurancePlanFinder;
    private final InsurancePlanSaver insurancePlanSaver;

    @Transactional
    public void createPlan(Worker planner, CreatePlanRequestDto createPlanRequestDto) {
        String fileUrl = "url";
        InsurancePlan insurancePlan = createPlanRequestDto.toEntity(planner, fileUrl);
        insurancePlanSaver.save(insurancePlan);
    }
}
