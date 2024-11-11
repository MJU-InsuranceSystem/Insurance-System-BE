package fourservings_fiveservings.insurance_system_be.user.service;

import fourservings_fiveservings.insurance_system_be.common.exception.BusinessException;
import fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType;
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

    public boolean isEmailExists (String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public User getUserInfoByEmail (String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException(ErrorType.NO_EXIST_EMAIL));
    }
}
