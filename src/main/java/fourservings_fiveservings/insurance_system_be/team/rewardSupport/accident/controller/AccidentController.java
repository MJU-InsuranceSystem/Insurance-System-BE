package fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.controller;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.constant.SuccessType;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.api.AccidentApi;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.controller.dto.request.RegisterAccidentRequestDto;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.service.AccidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccidentController implements AccidentApi {

    private final AccidentService accidentService;

    @Override
    public ApiResponse<?> registerAccident(CustomUserDetails customUserDetails,
                                           Long contractId,
                                           RegisterAccidentRequestDto registerAccidentRequestDto) {
        accidentService.createAccident(customUserDetails, contractId, registerAccidentRequestDto);
        return ApiResponse.success(SuccessType.SUCCESS);
    }
}
