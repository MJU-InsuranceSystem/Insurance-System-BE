package fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.controller;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.constant.SuccessType;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.api.AccidentApi;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.controller.dto.request.RegisterAccidentRequestDto;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.controller.dto.request.ReviewAccidentRequestDto;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.controller.dto.response.AccidentResponseDto;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.service.AccidentService;
import fourservings_fiveservings.insurance_system_be.user.entity.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Override
    public ApiResponse<List<AccidentResponseDto>> getAllAccidents(CustomUserDetails customUserDetails) {
        List<AccidentResponseDto> response = accidentService.getAllAccidents(customUserDetails);
        return ApiResponse.success(SuccessType.SUCCESS, response);
    }

    @Override
    public ApiResponse<AccidentResponseDto> getAccident(Long accidentId) {
        AccidentResponseDto response = accidentService.getAccident(accidentId);
        return ApiResponse.success(SuccessType.SUCCESS, response);
    }

    @Override
    public ApiResponse<?> reviewAccident(
        CustomUserDetails customUserDetails,
        Long id,
        ReviewAccidentRequestDto reviewAccidentRequestDto
    ) {
        Worker worker = customUserDetails.getWorker();
        accidentService.review(worker, id, reviewAccidentRequestDto);
        return ApiResponse.success(SuccessType.SUCCESS);
    }
}
