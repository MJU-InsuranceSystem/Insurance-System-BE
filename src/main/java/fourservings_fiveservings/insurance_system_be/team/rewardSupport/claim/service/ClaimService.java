package fourservings_fiveservings.insurance_system_be.team.rewardSupport.claim.service;

import fourservings_fiveservings.insurance_system_be.common.exception.BusinessException;
import fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.entity.Accident;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.repository.AccidentRepository;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.claim.controller.dto.request.CreateClaimRequestDto;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.claim.controller.dto.response.ClaimListResponse;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.claim.entity.Claim;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.claim.service.implement.ClaimFinder;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.claim.service.implement.ClaimSaver;
import fourservings_fiveservings.insurance_system_be.user.entity.Worker;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClaimService {

    private final ClaimSaver claimSaver;
    private final ClaimFinder claimFinder;
    private final AccidentRepository accidentRepository;

    public void create(Worker worker, CreateClaimRequestDto createClaimRequestDto, Long accidentId) {
        Accident accident = accidentRepository.findById(accidentId)
            .orElseThrow(() -> new BusinessException(ErrorType.NO_EXIST_ACCIDENT));
        Claim claim = createClaimRequestDto.toEntity(worker, accident);
        claimSaver.save(claim);
    }

    public List<ClaimListResponse> getAll() {
        List<Claim> claims = claimFinder.getAll();
        return claims.stream()
            .map(ClaimListResponse::from)
            .toList();
    }
}
