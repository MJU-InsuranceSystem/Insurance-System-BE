package fourservings_fiveservings.insurance_system_be.team.underwrite.control;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.constant.SuccessType;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.team.underwrite.api.UnderwriteApi;
import fourservings_fiveservings.insurance_system_be.team.underwrite.control.dto.request.UnderwriteRequestDto;
import fourservings_fiveservings.insurance_system_be.team.underwrite.service.UnderWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UnderWriteControl implements UnderwriteApi {

    private final UnderWriteService underWriteService;

    @Override
    public ApiResponse<?> approveContract(CustomUserDetails customUserDetails, Long contractId,
        UnderwriteRequestDto approveContractRequestDto) {
        underWriteService.approveContract(customUserDetails.getWorker(), contractId,
            approveContractRequestDto);
        return ApiResponse.success(SuccessType.SUCCESS);
    }
}
