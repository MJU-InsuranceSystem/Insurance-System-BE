package fourservings_fiveservings.insurance_system_be.team.plan.service.implement;

import fourservings_fiveservings.insurance_system_be.team.plan.entity.InsurancePlan;
import fourservings_fiveservings.insurance_system_be.team.plan.repository.InsurancePlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class InsurancePlanSaver {

    private final InsurancePlanRepository insurancePlanRepository;

    public void save(InsurancePlan insurancePlan) {
        insurancePlanRepository.save(insurancePlan);
    }
}
