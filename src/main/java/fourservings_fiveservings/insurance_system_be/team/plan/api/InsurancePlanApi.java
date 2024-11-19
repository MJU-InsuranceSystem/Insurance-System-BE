package fourservings_fiveservings.insurance_system_be.team.plan.api;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.team.plan.controller.dto.request.CreatePlanRequestDto;
import fourservings_fiveservings.insurance_system_be.team.plan.controller.dto.request.ReviewPlanRequestDto;
import fourservings_fiveservings.insurance_system_be.team.plan.controller.dto.response.InsurancePlanListResponse;
import fourservings_fiveservings.insurance_system_be.team.plan.controller.dto.response.InsurancePlanResponse;
import java.util.List;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/insurances/plans", produces = "application/json;charset=utf-8")
public interface InsurancePlanApi {

    @PostMapping
    ApiResponse<?> createPlan(
        @AuthenticationPrincipal CustomUserDetails customUserDetails,
        @ModelAttribute CreatePlanRequestDto createPlanRequestDto
    );

    @GetMapping
    ApiResponse<List<InsurancePlanListResponse>> getAllInsurancePlans();

    @GetMapping("{planId}")
    ApiResponse<InsurancePlanResponse> getInsurancePlan(@PathVariable("planId") Long planId);

    @PatchMapping("/{planId}/review")
    ApiResponse<?> reviewPlan(
        @AuthenticationPrincipal CustomUserDetails customUserDetails,
        @PathVariable(name = "planId") Long planId,
        @RequestBody ReviewPlanRequestDto reviewPlanRequestDto
        );
}
