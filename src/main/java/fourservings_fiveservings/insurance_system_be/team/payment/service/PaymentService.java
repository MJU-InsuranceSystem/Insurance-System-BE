package fourservings_fiveservings.insurance_system_be.team.payment.service;

import static fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType.INSUFFICIENT_BALANCE;
import static fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType.INVALID_PAYMENT_AMOUNT;
import static fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType.NO_EXIST_ACCOUNT_INFO;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.exception.BusinessException;
import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.common.Contract;
import fourservings_fiveservings.insurance_system_be.team.contract.service.implement.ContractFinder;
import fourservings_fiveservings.insurance_system_be.team.payment.controller.dto.request.PayRequestDto;
import fourservings_fiveservings.insurance_system_be.team.payment.controller.dto.response.PaymentListResponse;
import fourservings_fiveservings.insurance_system_be.team.payment.entity.Payment;
import fourservings_fiveservings.insurance_system_be.team.payment.repository.PaymentRepository;
import fourservings_fiveservings.insurance_system_be.user.entity.Customer;
import fourservings_fiveservings.insurance_system_be.user.service.implement.UserSaver;
import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PaymentService {

    private final ContractFinder contractFinder;
    private final UserSaver userSaver;

    private final PaymentRepository paymentRepository;

    @Transactional
    public void pay(CustomUserDetails customUserDetails, Long contractId,
        PayRequestDto payRequestDto) {
        Customer customer = customUserDetails.getCustom();
        Contract contract = contractFinder.findById(contractId);

        BigDecimal monthlyPaymentAmount = contract.getInsurance().getMonthlyPremium();
        BigDecimal customerAccountBalance =
            customer.getAccount() != null ? customer.getAccount().getBalance() : BigDecimal.ZERO;

        if (customer.getAccount() == null || customer.getAccount().getAccountNumber() == null) {
            throw new BusinessException(NO_EXIST_ACCOUNT_INFO);
        }
        if (monthlyPaymentAmount.compareTo(customerAccountBalance) > 0) {
            throw new BusinessException(INSUFFICIENT_BALANCE);
        }
        if (payRequestDto.amount().compareTo(monthlyPaymentAmount) != 0) {
            throw new BusinessException(INVALID_PAYMENT_AMOUNT);
        }

        paymentRepository.save(payRequestDto.toPayment(contract));
        customer.payAmount(monthlyPaymentAmount);
        userSaver.save(customer);
    }

    public List<PaymentListResponse> getPaymentsByContractId(Long contractId) {
        List<Payment> paymentList = paymentRepository.findByContractId(contractId);
        return paymentList.stream()
            .map(PaymentListResponse::from)
            .toList();
    }
}
