package fourservings_fiveservings.insurance_system_be.team.payment.controller;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.constant.SuccessType;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.team.payment.api.PaymentApi;
import fourservings_fiveservings.insurance_system_be.team.payment.controller.dto.request.PayRequestDto;
import fourservings_fiveservings.insurance_system_be.team.payment.service.PaymentService;
import fourservings_fiveservings.insurance_system_be.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaymentController implements PaymentApi {

    private final PaymentService paymentService;

    @Override
    public ApiResponse<?> pay(CustomUserDetails userDetails,
                              Long contractId,
                              PayRequestDto payRequestDto) {
        User customer = userDetails.getCustom();
        paymentService.pay(customer, contractId, payRequestDto);
        return ApiResponse.success(SuccessType.SUCCESS);
    }
}
