package fourservings_fiveservings.insurance_system_be.team.plan.service.implement;

import fourservings_fiveservings.insurance_system_be.team.plan.repository.InsurancePlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InsurancePlanFinder {

    private final InsurancePlanRepository insurancePlanRepository;

}
