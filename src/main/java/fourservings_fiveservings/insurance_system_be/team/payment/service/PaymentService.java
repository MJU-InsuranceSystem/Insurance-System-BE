package fourservings_fiveservings.insurance_system_be.team.payment.service;

import fourservings_fiveservings.insurance_system_be.team.payment.controller.dto.request.PayRequestDto;
import fourservings_fiveservings.insurance_system_be.team.payment.repository.PaymentRepository;
import fourservings_fiveservings.insurance_system_be.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Transactional
    public void pay(User customer, Long contractId, PayRequestDto payRequestDto) {

    }
}
