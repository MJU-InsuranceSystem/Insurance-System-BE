package fourservings_fiveservings.insurance_system_be.auth.service;

import fourservings_fiveservings.insurance_system_be.auth.dto.request.SignUpRequestDto;
import fourservings_fiveservings.insurance_system_be.auth.jwt.service.JwtService;
import fourservings_fiveservings.insurance_system_be.domain.user.UserType;
import fourservings_fiveservings.insurance_system_be.domain.user.entity.User;
import fourservings_fiveservings.insurance_system_be.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtService;
    private final UserRepository<User> userRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(SignUpRequestDto signUpRequestDto) {
        String encodedPassword = passwordEncoder.encode(signUpRequestDto.password());
        User user = null;
        if (signUpRequestDto.userType() == UserType.CUSTOMER) {
           user = userRepository.save(signUpRequestDto.toCustomer(encodedPassword));
        } else {
            userRepository.save(signUpRequestDto.toWorker(encodedPassword));
        }

    }
}
