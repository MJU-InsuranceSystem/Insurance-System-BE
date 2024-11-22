package fourservings_fiveservings.insurance_system_be.team.rewardSupport.claim.repository;

import fourservings_fiveservings.insurance_system_be.team.rewardSupport.claim.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Long> {

}
