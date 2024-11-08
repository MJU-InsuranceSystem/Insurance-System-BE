package fourservings_fiveservings.insurance_system_be.domain.user.repository;

import fourservings_fiveservings.insurance_system_be.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository<T extends User> extends JpaRepository<T, Long> {
    Optional<User> findByEmail(String email);
}
