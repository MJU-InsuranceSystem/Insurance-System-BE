package fourservings_fiveservings.insurance_system_be.auth.jwt.repository;

import fourservings_fiveservings.insurance_system_be.auth.jwt.entity.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}
