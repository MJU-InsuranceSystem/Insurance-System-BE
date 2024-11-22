package fourservings_fiveservings.insurance_system_be.user.service.implement;

import fourservings_fiveservings.insurance_system_be.user.entity.User;
import fourservings_fiveservings.insurance_system_be.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserSaver {

    private final UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }
}
