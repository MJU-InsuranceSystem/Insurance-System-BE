package fourservings_fiveservings.insurance_system_be.team.insurance.repository;

import fourservings_fiveservings.insurance_system_be.team.insurance.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

}
