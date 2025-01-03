package fourservings_fiveservings.insurance_system_be.team.underwrite.service;

import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.Contract;
import fourservings_fiveservings.insurance_system_be.team.contract.common.repository.ContractRepository;
import fourservings_fiveservings.insurance_system_be.team.underwrite.controller.dto.request.UnderwriteRequestDto;
import fourservings_fiveservings.insurance_system_be.user.entity.Worker;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UnderWriteService {

    private final ContractRepository contractRepository;

    @Transactional
    public void approveContract(Worker underwriteManager, Long contractId,
        UnderwriteRequestDto underwriteRequestDto) {
        Contract contract = contractRepository.findById(contractId).orElseThrow(
            EntityNotFoundException::new);
        contract.updateApproveStatus(underwriteManager, underwriteRequestDto.approveStatus());
    }
}
