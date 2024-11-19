package fourservings_fiveservings.insurance_system_be.team.plan.service.implement;

import fourservings_fiveservings.insurance_system_be.common.exception.ResourceNotFoundException;
import fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType;
import fourservings_fiveservings.insurance_system_be.team.plan.entity.InsurancePlan;
import fourservings_fiveservings.insurance_system_be.team.plan.repository.InsurancePlanRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InsurancePlanFinder {

    private final InsurancePlanRepository insurancePlanRepository;

    public List<InsurancePlan> getAll() {
        return insurancePlanRepository.findAll();
    }

    public InsurancePlan findById(Long insurancePlanId) {
        return insurancePlanRepository.findById(insurancePlanId)
            .orElseThrow(() -> new ResourceNotFoundException(ErrorType.RESOURCE_NOT_FOUND));
    }
}
