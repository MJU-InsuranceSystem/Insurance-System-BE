package fourservings_fiveservings.insurance_system_be.team.underwrite.control;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.constant.SuccessType;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.team.underwrite.api.UnderwriteApi;
import fourservings_fiveservings.insurance_system_be.team.underwrite.service.UnderWriteService;
import fourservings_fiveservings.insurance_system_be.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UnderWriteControl implements UnderwriteApi {

    private final UnderWriteService underWriteService;

    @Override
    public ApiResponse<?> approveContract(CustomUserDetails customUserDetails, Integer contractId) {
        User user = customUserDetails.getUser();
        underWriteService.approveContract(user, contractId);
        return ApiResponse.success(SuccessType.SUCCESS);
    }
}
