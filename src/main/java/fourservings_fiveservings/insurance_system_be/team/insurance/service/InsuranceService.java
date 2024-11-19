package fourservings_fiveservings.insurance_system_be.team.insurance.service;

import fourservings_fiveservings.insurance_system_be.team.insurance.controller.dto.request.CreateInsuranceRequestDto;
import fourservings_fiveservings.insurance_system_be.team.insurance.entity.Insurance;
import fourservings_fiveservings.insurance_system_be.team.insurance.service.implement.InsuranceSaver;
import fourservings_fiveservings.insurance_system_be.user.entity.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InsuranceService {

    private final InsuranceSaver insuranceSaver;

    @Transactional
    public void create(CreateInsuranceRequestDto createInsuranceRequestDto, Worker worker) {
        Insurance insurance = createInsuranceRequestDto.toEntity(worker);
        insuranceSaver.save(insurance);
    }
}
