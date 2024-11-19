package fourservings_fiveservings.insurance_system_be.team.plan.api;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.team.plan.controller.dto.request.CreatePlanRequestDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/insurances", produces = "application/json;charset=utf-8")
public interface InsurancePlanApi {

    @PostMapping("/plans")
    ApiResponse<?> createPlan(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                 @ModelAttribute CreatePlanRequestDto createPlanRequestDto);

    @GetMapping("/plans")
    ApiResponse<?> getAllInsurancePlans();

    @PatchMapping("/{productId}")
    ApiResponse<?> approveProduct(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                  @PathVariable(name = "productId") Long productId);
}
