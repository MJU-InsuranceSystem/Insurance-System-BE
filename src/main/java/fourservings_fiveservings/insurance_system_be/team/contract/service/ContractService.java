package fourservings_fiveservings.insurance_system_be.team.contract.service;

import fourservings_fiveservings.insurance_system_be.team.contract.controller.dto.request.CarInsuranceJoinRequestDto;
import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.Contract;
import fourservings_fiveservings.insurance_system_be.team.contract.repository.ContractRepository;
import fourservings_fiveservings.insurance_system_be.team.product.entity.Product;
import fourservings_fiveservings.insurance_system_be.team.product.insurance.ApproveStatus;
import fourservings_fiveservings.insurance_system_be.team.product.repository.ProductRepository;
import fourservings_fiveservings.insurance_system_be.team.product.service.componet.ProductManager;
import fourservings_fiveservings.insurance_system_be.user.entity.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ContractService {

    private final ProductRepository productRepository;
    private final ProductManager productManager;
    private final ContractRepository contractRepository;

    @Transactional
    public void processCarContract(User appliedCustomer, Long productId,
        CarInsuranceJoinRequestDto carInsuranceJoinRequestDto) {
        Product product = productManager.checkProduct(productRepository.findById(productId));
        Contract contract = carInsuranceJoinRequestDto.createPendingCarContract(appliedCustomer,
            product);
        contractRepository.save(contract);
    }

    public List<Contract> getUnapprovedContracts() {
        List<Contract> unapprovedContracts = contractRepository.findByApproveStatus(
            ApproveStatus.PENDING);
        return unapprovedContracts;
    }
}
