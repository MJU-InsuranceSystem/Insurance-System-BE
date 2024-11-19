package fourservings_fiveservings.insurance_system_be.team.payment.service;

import static fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType.INSUFFICIENT_BALANCE;
import static fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType.INVALID_PAYMENT_AMOUNT;
import static fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType.NO_EXIST_ACCOUNT_INFO;
import static fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType.NO_EXIST_CONTRACT;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.exception.BusinessException;
import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.Contract;
import fourservings_fiveservings.insurance_system_be.team.contract.repository.ContractRepository;
import fourservings_fiveservings.insurance_system_be.team.payment.controller.dto.request.PayRequestDto;
import fourservings_fiveservings.insurance_system_be.team.payment.repository.PaymentRepository;
import fourservings_fiveservings.insurance_system_be.user.entity.Customer;
import fourservings_fiveservings.insurance_system_be.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final ContractRepository contractRepository;
    private final UserRepository userRepository;

    @Transactional
    public void pay(CustomUserDetails customUserDetails, Long contractId, PayRequestDto payRequestDto) {
        Customer customer = customUserDetails.getCustom();
        Contract contract = contractRepository.findById(contractId)
                .orElseThrow(() -> new BusinessException(NO_EXIST_CONTRACT));

        int monthlyPaymentAmount = contract.getInsurance().getMonthlyPremium().intValue();
        int customerAccountBalance = customer.getAccount().getBalance();

        if (customer.getAccount().getAccountNumber() == null) {
            throw new BusinessException(NO_EXIST_ACCOUNT_INFO);
        }

        if (monthlyPaymentAmount > customerAccountBalance) {
            throw new BusinessException(INSUFFICIENT_BALANCE);
        }

        if (payRequestDto.amount() != monthlyPaymentAmount) {
            throw new BusinessException(INVALID_PAYMENT_AMOUNT);
        }
        // 은행이 일치하는지도 validate

        paymentRepository.save(payRequestDto.toPayment(contract));

        customer.payAmount(monthlyPaymentAmount);
        userRepository.saveAndFlush(customer);
    }
}
