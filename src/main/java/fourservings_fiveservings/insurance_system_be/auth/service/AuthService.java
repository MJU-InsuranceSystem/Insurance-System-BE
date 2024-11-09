package fourservings_fiveservings.insurance_system_be.auth.service;

import fourservings_fiveservings.insurance_system_be.auth.dto.request.SignInRequestDto;
import fourservings_fiveservings.insurance_system_be.auth.dto.request.SignUpRequestDto;
import fourservings_fiveservings.insurance_system_be.auth.jwt.dto.TokenDto;
import fourservings_fiveservings.insurance_system_be.auth.jwt.service.JwtService;
import fourservings_fiveservings.insurance_system_be.common.exception.BusinessException;
import fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType;
import fourservings_fiveservings.insurance_system_be.domain.user.UserType;
import fourservings_fiveservings.insurance_system_be.domain.user.entity.User;
import fourservings_fiveservings.insurance_system_be.domain.user.repository.UserRepository;
import fourservings_fiveservings.insurance_system_be.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtService;
    private final UserService userService;
    private final UserRepository<User> userRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(SignUpRequestDto signUpRequestDto) {
        if (userService.isEmailExists(signUpRequestDto.email())) {
            throw new BusinessException(ErrorType.EXIST_EMAIL);
        }

        String encodedPassword = passwordEncoder.encode(signUpRequestDto.password());
        if (signUpRequestDto.userType() == UserType.CUSTOMER) {
            userRepository.save(signUpRequestDto.toCustomer(encodedPassword));
        } else {
            userRepository.save(signUpRequestDto.toWorker(encodedPassword));
        }
    }

    public TokenDto signIn(SignInRequestDto signInRequestDto) {
        User user = userRepository.findByEmail(signInRequestDto.email())
                .orElseThrow(() -> new BusinessException(ErrorType.NO_EXIST_EMAIL));

        if (!user.isPasswordValid(passwordEncoder, signInRequestDto.password())) {
            throw new BusinessException(ErrorType.MISMATCH_PASSWORD);
        }

        return jwtService.signIn(signInRequestDto.email(), signInRequestDto.password());
    }
}
