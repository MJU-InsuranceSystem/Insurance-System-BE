package fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.repository;

import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.entity.Accident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccidentRepository extends JpaRepository<Accident, Long> {
}
