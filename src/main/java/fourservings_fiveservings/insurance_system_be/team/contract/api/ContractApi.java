package fourservings_fiveservings.insurance_system_be.team.contract.api;


import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/contracts", produces = "application/json;charset=utf-8")
public interface ContractApi {

    @PostMapping("/{product-id}")
    ApiResponse<?> joinInsurance(@AuthenticationPrincipal CustomUserDetails customUserDetails,
        @PathVariable(value = "product-id") Long productId);

    @GetMapping("/un-approved")
    ApiResponse<?> getUnApprovedContracts();

}
