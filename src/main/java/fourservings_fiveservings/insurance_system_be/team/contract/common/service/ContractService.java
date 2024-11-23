package fourservings_fiveservings.insurance_system_be.team.contract.common.service;

import fourservings_fiveservings.insurance_system_be.team.contract.common.controller.dto.response.ContractListResponseDto;
import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.common.ApproveStatus;
import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.common.Contract;
import fourservings_fiveservings.insurance_system_be.team.contract.common.repository.ContractRepository;
import fourservings_fiveservings.insurance_system_be.team.insurance.service.implement.InsuranceFinder;
import fourservings_fiveservings.insurance_system_be.user.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ContractService {

    private final InsuranceFinder insuranceFinder;
    private final ContractRepository contractRepository;
    private final UserRepository userRepository;

    public List<Contract> getUnapprovedContracts() {
        List<Contract> unapprovedContracts = contractRepository.findByApproveStatus(
            ApproveStatus.PENDING);
        return unapprovedContracts;
    }


    public List<ContractListResponseDto> getAllContracts() {
        return contractRepository.findAll().stream()
            .map(ContractListResponseDto::of)
            .collect(Collectors.toList());
    }


    public List<ContractListResponseDto> getContractListBySubscriberId(Long subscriberId) {
        return contractRepository.findBySubscriberId(subscriberId).stream()
            .map(ContractListResponseDto::of)
            .toList();
    }
}
