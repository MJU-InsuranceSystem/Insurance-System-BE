package fourservings_fiveservings.insurance_system_be.team.rewardSupport.claim.service.implement;

import fourservings_fiveservings.insurance_system_be.team.rewardSupport.claim.entity.Claim;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.claim.repository.ClaimRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClaimFinder {

    private final ClaimRepository claimRepository;

    public List<Claim> getAll() {
        return claimRepository.findAll();
    }
}
