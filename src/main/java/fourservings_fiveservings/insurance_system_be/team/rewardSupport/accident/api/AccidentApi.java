package fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.api;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.controller.dto.request.RegisterAccidentRequestDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/accidents", produces = "application/json;charset=utf-8")
public interface AccidentApi {

    @PostMapping("/contract/{contractId}")
    ApiResponse<?> registerAccident(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                    @PathVariable(value = "contractId") Long contractId,
                                    @RequestBody RegisterAccidentRequestDto registerAccidentRequestDto);
}
