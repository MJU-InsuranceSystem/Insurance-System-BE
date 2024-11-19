package fourservings_fiveservings.insurance_system_be.team.insurance.controller;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.constant.SuccessType;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.team.insurance.api.InsuranceApi;
import fourservings_fiveservings.insurance_system_be.team.insurance.controller.dto.request.CreateInsuranceRequestDto;
import fourservings_fiveservings.insurance_system_be.team.insurance.service.InsuranceService;
import fourservings_fiveservings.insurance_system_be.user.entity.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InsuranceController implements InsuranceApi {

    private final InsuranceService insuranceService;

    @Override
    public ApiResponse<?> createInsurance(
        CustomUserDetails customUserDetails,
        CreateInsuranceRequestDto createInsuranceRequestDto
    ) {
        Worker worker = customUserDetails.getWorker();
        insuranceService.create(createInsuranceRequestDto, worker);
        return ApiResponse.success(SuccessType.SUCCESS);
    }
}
