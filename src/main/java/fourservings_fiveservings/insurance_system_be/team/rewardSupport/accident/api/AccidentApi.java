package fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.api;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.controller.dto.request.RegisterAccidentRequestDto;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.controller.dto.response.AccidentListResponseDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/accidents", produces = "application/json;charset=utf-8")
public interface AccidentApi {

    @PostMapping("/contract/{contractId}")
    ApiResponse<?> registerAccident(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                    @PathVariable(value = "contractId") Long contractId,
                                    @RequestBody RegisterAccidentRequestDto registerAccidentRequestDto);

    @GetMapping
    ApiResponse<List<AccidentListResponseDto>> getAllAccidents(@AuthenticationPrincipal CustomUserDetails customUserDetails);

}
