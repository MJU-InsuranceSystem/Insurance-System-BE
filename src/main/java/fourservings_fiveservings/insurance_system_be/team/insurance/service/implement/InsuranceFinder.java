package fourservings_fiveservings.insurance_system_be.team.insurance.service.implement;

import fourservings_fiveservings.insurance_system_be.common.exception.ResourceNotFoundException;
import fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType;
import fourservings_fiveservings.insurance_system_be.team.insurance.entity.Insurance;
import fourservings_fiveservings.insurance_system_be.team.insurance.repository.InsuranceRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InsuranceFinder {

    private final InsuranceRepository insuranceRepository;

    public Insurance findById(Long id) {
        return insuranceRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(ErrorType.RESOURCE_NOT_FOUND));
    }

    public List<Insurance> getAll() {
        return insuranceRepository.findAll();
    }
}
