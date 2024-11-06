package fourservings_fiveservings.insurance_system_be.user.auth;

import fourservings_fiveservings.insurance_system_be.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository<T extends User> extends JpaRepository<T, Long> {

}
