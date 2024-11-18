package fourservings_fiveservings.insurance_system_be.team.payment.api;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.team.payment.controller.dto.request.PayRequestDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/payments", produces = "application/json;charset=utf-8")
public interface PaymentApi {

    // GET /api/v1/payments/contracts/{contractId}

    @PostMapping("/contracts/{contractId}")
    ApiResponse<?> pay(@AuthenticationPrincipal CustomUserDetails userDetails,
                       @PathVariable(value = "contractId") Long contractId,
                       @RequestBody PayRequestDto payRequestDto);
}
