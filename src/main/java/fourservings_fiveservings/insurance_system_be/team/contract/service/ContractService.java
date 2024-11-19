package fourservings_fiveservings.insurance_system_be.team.contract.service;

import fourservings_fiveservings.insurance_system_be.team.contract.controller.dto.request.CarInsuranceJoinRequestDto;
import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.ApproveStatus;
import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.Contract;
import fourservings_fiveservings.insurance_system_be.team.contract.repository.ContractRepository;
import fourservings_fiveservings.insurance_system_be.team.insurance.entity.Insurance;
import fourservings_fiveservings.insurance_system_be.team.insurance.service.implement.InsuranceFinder;
import fourservings_fiveservings.insurance_system_be.user.entity.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ContractService {

    private final InsuranceFinder insuranceFinder;
    private final ContractRepository contractRepository;

    @Transactional
    public void processCarContract(User appliedCustomer, Long productId,
        CarInsuranceJoinRequestDto carInsuranceJoinRequestDto) {
        Insurance insurance = insuranceFinder.findById(productId);
        Contract contract = carInsuranceJoinRequestDto.createPendingCarContract(appliedCustomer,
            insurance);
        contractRepository.save(contract);
    }

    public List<Contract> getUnapprovedContracts() {
        List<Contract> unapprovedContracts = contractRepository.findByApproveStatus(
            ApproveStatus.PENDING);
        return unapprovedContracts;
    }
}
