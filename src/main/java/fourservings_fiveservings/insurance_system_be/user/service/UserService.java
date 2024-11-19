package fourservings_fiveservings.insurance_system_be.user.service;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.exception.BusinessException;
import fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType;
import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.type.Bank;
import fourservings_fiveservings.insurance_system_be.user.controller.dto.request.SetAccountRequestDto;
import fourservings_fiveservings.insurance_system_be.user.entity.Customer;
import fourservings_fiveservings.insurance_system_be.user.entity.User;
import fourservings_fiveservings.insurance_system_be.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository<User> userRepository;

    @Transactional
    public void setAccount(CustomUserDetails customUserDetails, SetAccountRequestDto setAccountRequestDto) {
        Customer customer = customUserDetails.getCustom();
        Bank bank = Bank.fromName(setAccountRequestDto.bankName());
        customer.addAccountInfo(bank, setAccountRequestDto.accountNumber(), setAccountRequestDto.balance());

        userRepository.saveAndFlush(customer);
    }

    public boolean isEmailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public User getUserInfoByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException(ErrorType.NO_EXIST_EMAIL));
    }
}
