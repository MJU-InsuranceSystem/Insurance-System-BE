package fourservings_fiveservings.insurance_system_be.team.rewardSupport.claim.controller;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.constant.SuccessType;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.claim.api.ClaimApi;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.claim.controller.dto.request.CreateClaimRequestDto;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.claim.service.ClaimService;
import fourservings_fiveservings.insurance_system_be.user.entity.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClaimController implements ClaimApi {

    private final ClaimService claimService;

    @Override
    public ApiResponse<?> createClaim(
        CustomUserDetails customUserDetails,
        CreateClaimRequestDto createClaimRequestDto,
        Long accidentId
    ) {
        Worker worker = customUserDetails.getWorker();
        claimService.create(worker, createClaimRequestDto, accidentId);
        return ApiResponse.success(SuccessType.SUCCESS);
    }
}
