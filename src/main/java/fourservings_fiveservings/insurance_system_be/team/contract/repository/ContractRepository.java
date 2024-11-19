package fourservings_fiveservings.insurance_system_be.team.contract.repository;

import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.ApproveStatus;
import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.Contract;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Integer> {

    List<Contract> findByApproveStatus(ApproveStatus approveStatus);
}
