package fourservings_fiveservings.insurance_system_be.team.rewardSupport.claim.service.implement;

import fourservings_fiveservings.insurance_system_be.team.rewardSupport.claim.entity.Claim;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.claim.repository.ClaimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ClaimSaver {

    private final ClaimRepository claimRepository;

    public void save(Claim claim) {
        claimRepository.save(claim);
    }
}
