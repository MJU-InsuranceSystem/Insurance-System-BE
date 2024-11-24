package fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.api;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.controller.dto.request.RegisterAccidentRequestDto;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.controller.dto.request.ReviewAccidentRequestDto;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.controller.dto.response.AccidentResponseDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/accidents", produces = "application/json;charset=utf-8")
public interface AccidentApi {

    @PostMapping("/contracts/{contractId}")
    ApiResponse<?> registerAccident(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                    @PathVariable(value = "contractId") Long contractId,
                                    @RequestBody RegisterAccidentRequestDto registerAccidentRequestDto);

    @GetMapping
    ApiResponse<List<AccidentResponseDto>> getAllAccidents(@AuthenticationPrincipal CustomUserDetails customUserDetails);

    @GetMapping("/{accidentId}")
    ApiResponse<AccidentResponseDto> getAccident(@PathVariable(value = "accidentId") Long accidentId);

    @PatchMapping("/{accidentId}/liability")
    ApiResponse<?> reviewAccident(
        @AuthenticationPrincipal CustomUserDetails customUserDetails,
        @PathVariable("accidentId") Long id,
        @RequestBody ReviewAccidentRequestDto reviewAccidentRequestDto
    );
}
