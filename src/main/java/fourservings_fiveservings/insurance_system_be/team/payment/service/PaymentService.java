package fourservings_fiveservings.insurance_system_be.team.payment.service;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.exception.BusinessException;
import fourservings_fiveservings.insurance_system_be.team.payment.controller.dto.request.PayRequestDto;
import fourservings_fiveservings.insurance_system_be.team.payment.repository.PaymentRepository;
import fourservings_fiveservings.insurance_system_be.user.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType.NO_EXIST_ACCOUNT_INFO;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;


    @Transactional
    public void pay(CustomUserDetails customUserDetails, Long contractId, PayRequestDto payRequestDto) {
        Customer customer = customUserDetails.getCustom();

        if (customer.getAccount() == null) {
            throw new BusinessException(NO_EXIST_ACCOUNT_INFO);
        }

    }
}
