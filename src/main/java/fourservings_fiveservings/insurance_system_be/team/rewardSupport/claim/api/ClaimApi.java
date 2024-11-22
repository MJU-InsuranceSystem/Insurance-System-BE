package fourservings_fiveservings.insurance_system_be.team.rewardSupport.claim.api;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.claim.controller.dto.request.CreateClaimRequestDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public interface ClaimApi {

    @PostMapping("accidents/{accidentId}/claims")
    ApiResponse<?> createClaim(
        @AuthenticationPrincipal CustomUserDetails customUserDetails,
        @RequestBody CreateClaimRequestDto createClaimRequestDto,
        @PathVariable("accidentId") Long accidentId
    );
}
