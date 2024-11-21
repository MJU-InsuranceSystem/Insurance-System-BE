package fourservings_fiveservings.insurance_system_be.user.service;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.exception.BusinessException;
import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.type.Bank;
import fourservings_fiveservings.insurance_system_be.user.controller.dto.request.SetAccountRequestDto;
import fourservings_fiveservings.insurance_system_be.user.entity.Customer;
import fourservings_fiveservings.insurance_system_be.user.entity.User;
import fourservings_fiveservings.insurance_system_be.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType.NO_EXIST_EMAIL;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void setAccount(CustomUserDetails customUserDetails, SetAccountRequestDto setAccountRequestDto) {
        Customer customer = customUserDetails.getCustom();
        Bank bank = Bank.fromName(setAccountRequestDto.bankName());
        customer.addAccountInfo(bank, setAccountRequestDto.accountNumber(), setAccountRequestDto.balance());

        userRepository.save(customer);
    }

    public boolean isEmailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public User getUserInfoByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException(NO_EXIST_EMAIL));
    }
}
