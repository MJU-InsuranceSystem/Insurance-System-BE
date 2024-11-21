package fourservings_fiveservings.insurance_system_be.team.payment.api;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.team.payment.controller.dto.request.PayRequestDto;
import fourservings_fiveservings.insurance_system_be.team.payment.controller.dto.response.PaymentListResponse;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/payments", produces = "application/json;charset=utf-8")
public interface PaymentApi {

    @PostMapping("/contracts/{contractId}")
    ApiResponse<?> pay(@AuthenticationPrincipal CustomUserDetails userDetails,
                       @PathVariable(value = "contractId") Long contractId,
                       @RequestBody PayRequestDto payRequestDto);

    @GetMapping("/contracts/{contractId}")
    ApiResponse<List<PaymentListResponse>> getPayments(@PathVariable(value = "contractId") Long contractId);
}
