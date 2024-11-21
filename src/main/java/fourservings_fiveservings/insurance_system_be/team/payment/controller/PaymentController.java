package fourservings_fiveservings.insurance_system_be.team.payment.controller;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.constant.SuccessType;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.team.payment.api.PaymentApi;
import fourservings_fiveservings.insurance_system_be.team.payment.controller.dto.request.PayRequestDto;
import fourservings_fiveservings.insurance_system_be.team.payment.controller.dto.response.PaymentListResponse;
import fourservings_fiveservings.insurance_system_be.team.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PaymentController implements PaymentApi {

    private final PaymentService paymentService;

    @Override
    public ApiResponse<?> pay(CustomUserDetails userDetails,
                              Long contractId,
                              PayRequestDto payRequestDto) {
        paymentService.pay(userDetails, contractId, payRequestDto);
        return ApiResponse.success(SuccessType.SUCCESS);
    }

    @Override
    public ApiResponse<List<PaymentListResponse>> getPayments(Long contractId) {
        List<PaymentListResponse> response = paymentService.getPaymentsByContractId(contractId);
        return ApiResponse.success(SuccessType.SUCCESS, response);
    }
}
