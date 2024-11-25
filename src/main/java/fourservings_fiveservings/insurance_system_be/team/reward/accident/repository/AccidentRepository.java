package fourservings_fiveservings.insurance_system_be.team.reward.accident.repository;

import fourservings_fiveservings.insurance_system_be.team.reward.accident.entity.Accident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccidentRepository extends JpaRepository<Accident, Long> {
    List<Accident> findAllByCustomerId(Long customerId);
}
