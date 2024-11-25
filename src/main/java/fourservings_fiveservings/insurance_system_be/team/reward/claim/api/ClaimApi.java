package fourservings_fiveservings.insurance_system_be.team.reward.claim.api;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.team.reward.claim.controller.dto.request.CreateClaimRequestDto;
import fourservings_fiveservings.insurance_system_be.team.reward.claim.controller.dto.response.ClaimListResponse;
import java.util.List;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/claims")
    ApiResponse<List<ClaimListResponse>> getAllClaims();
}
