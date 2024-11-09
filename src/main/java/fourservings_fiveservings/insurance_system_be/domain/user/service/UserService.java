package fourservings_fiveservings.insurance_system_be.domain.user.service;

import fourservings_fiveservings.insurance_system_be.domain.user.entity.User;
import fourservings_fiveservings.insurance_system_be.domain.user.repository.UserRepository;
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
}
