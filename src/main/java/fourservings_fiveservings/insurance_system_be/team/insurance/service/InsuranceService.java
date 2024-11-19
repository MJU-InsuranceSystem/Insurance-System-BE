package fourservings_fiveservings.insurance_system_be.team.insurance.service;

import fourservings_fiveservings.insurance_system_be.team.insurance.controller.dto.request.CreateInsuranceRequestDto;
import fourservings_fiveservings.insurance_system_be.team.insurance.controller.dto.response.InsuranceListResponse;
import fourservings_fiveservings.insurance_system_be.team.insurance.controller.dto.response.InsuranceResponse;
import fourservings_fiveservings.insurance_system_be.team.insurance.entity.Insurance;
import fourservings_fiveservings.insurance_system_be.team.insurance.service.implement.InsuranceFinder;
import fourservings_fiveservings.insurance_system_be.team.insurance.service.implement.InsuranceSaver;
import fourservings_fiveservings.insurance_system_be.user.entity.Worker;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InsuranceService {

    private final InsuranceSaver insuranceSaver;
    private final InsuranceFinder insuranceFinder;

    @Transactional
    public void create(CreateInsuranceRequestDto createInsuranceRequestDto, Worker worker) {
        Insurance insurance = createInsuranceRequestDto.toEntity(worker);
        insuranceSaver.save(insurance);
    }

    public List<InsuranceListResponse> getAll() {
        List<Insurance> insurances = insuranceFinder.getAll();
        return insurances.stream()
            .map(InsuranceListResponse::from)
            .toList();
    }

    public InsuranceResponse getInsurance(Long insuranceId) {
        Insurance insurance = insuranceFinder.findById(insuranceId);
        return InsuranceResponse.from(insurance);
    }
}
