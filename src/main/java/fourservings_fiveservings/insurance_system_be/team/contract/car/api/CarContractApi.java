package fourservings_fiveservings.insurance_system_be.team.contract.car.api;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.team.contract.car.controller.dto.request.CreateCarContractRequestDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/contracts/car", produces = "application/json;charset=utf-8")
public interface CarContractApi {

    @PostMapping("/{insurance-id}")
    ApiResponse<?> createContract(@AuthenticationPrincipal CustomUserDetails userDetails,
                                  @PathVariable(value = "insurance-id") Long insuranceId,
                                  @RequestBody CreateCarContractRequestDto createCarContractRequestDto);

    @GetMapping("/{contract-id}")
    ApiResponse<?> getContractDetail(@PathVariable(value = "contract-id") Long contractId,
                                     @AuthenticationPrincipal CustomUserDetails customUserDetails);

}
