package fourservings_fiveservings.insurance_system_be.team.insurance.api;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.team.insurance.controller.dto.request.CreateInsuranceRequestDto;
import fourservings_fiveservings.insurance_system_be.team.insurance.controller.dto.response.InsuranceListResponse;
import fourservings_fiveservings.insurance_system_be.team.insurance.controller.dto.response.InsuranceResponse;
import java.util.List;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/insurances")
public interface InsuranceApi {

    @PostMapping
    ApiResponse<?> createInsurance(
        @AuthenticationPrincipal CustomUserDetails customUserDetails,
        @RequestBody CreateInsuranceRequestDto createInsuranceRequestDto
    );

    @GetMapping
    ApiResponse<List<InsuranceListResponse>> getAllInsurances();

    @GetMapping("{insuranceId}")
    ApiResponse<InsuranceResponse> getInsurance(@PathVariable Long insuranceId);
}
