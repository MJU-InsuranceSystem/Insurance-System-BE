package fourservings_fiveservings.insurance_system_be.auth.custom;

import fourservings_fiveservings.insurance_system_be.user.entity.User;
import fourservings_fiveservings.insurance_system_be.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository<User> userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException(email + "에 해당하는 정보가 없습니다."));
        return new CustomUserDetails(user);
    }
}
