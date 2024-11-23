package fourservings_fiveservings.insurance_system_be.team.contract.common.service.implement;

import static fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType.NO_EXIST_CONTRACT;

import fourservings_fiveservings.insurance_system_be.common.exception.BusinessException;
import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.common.Contract;
import fourservings_fiveservings.insurance_system_be.team.contract.common.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ContractFinder {

    private final ContractRepository contractRepository;

    public Contract findById(Long contractId) {
        return contractRepository.findById(contractId)
            .orElseThrow(() -> new BusinessException(NO_EXIST_CONTRACT));
    }
}
