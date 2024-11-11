package fourservings_fiveservings.insurance_system_be.team.contract.service;

import fourservings_fiveservings.insurance_system_be.domain.insurance.ApproveStatus;
import fourservings_fiveservings.insurance_system_be.domain.user.entity.User;
import fourservings_fiveservings.insurance_system_be.team.contract.entity.Contract;
import fourservings_fiveservings.insurance_system_be.team.contract.repository.ContractRepository;
import fourservings_fiveservings.insurance_system_be.team.product.entity.Product;
import fourservings_fiveservings.insurance_system_be.team.product.repository.ProductRepository;
import fourservings_fiveservings.insurance_system_be.team.product.service.componet.ProductManager;
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
    public void processContract(User appliedCustomer, Long productId) {
        Product product = productManager.checkProduct(productRepository.findById(productId));
        Contract contract = Contract.fromUnApproveContract(appliedCustomer, product);
        contractRepository.save(contract);
    }

    public List<Contract> getUnapprovedContracts() {
        List<Contract> unapprovedContracts = contractRepository.findByApproveStatus(
            ApproveStatus.UN_APPROVE);
        return unapprovedContracts;
    }
}
