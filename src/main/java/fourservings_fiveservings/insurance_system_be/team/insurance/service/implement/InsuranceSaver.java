package fourservings_fiveservings.insurance_system_be.team.insurance.service.implement;

import fourservings_fiveservings.insurance_system_be.team.insurance.entity.Insurance;
import fourservings_fiveservings.insurance_system_be.team.insurance.repository.InsuranceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class InsuranceSaver {

    private final InsuranceRepository insuranceRepository;

    public void save(Insurance insurance) {
        insuranceRepository.save(insurance);
    }
}
