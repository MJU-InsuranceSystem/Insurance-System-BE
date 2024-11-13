package fourservings_fiveservings.insurance_system_be.team.underwrite.service;

import fourservings_fiveservings.insurance_system_be.team.contract.entity.Contract;
import fourservings_fiveservings.insurance_system_be.team.contract.repository.ContractRepository;
import fourservings_fiveservings.insurance_system_be.user.entity.User;
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
    public void approveContract(User underwriteManager, Integer contractId) {
        Contract contract = contractRepository.findById(contractId).orElseThrow(
            EntityNotFoundException::new);
        contract.approveContract(underwriteManager);
    }
}
