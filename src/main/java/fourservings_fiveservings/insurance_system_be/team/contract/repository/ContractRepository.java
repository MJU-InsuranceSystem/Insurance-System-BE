package fourservings_fiveservings.insurance_system_be.team.contract.repository;

import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.ApproveStatus;
import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, Long> {

    List<Contract> findByApproveStatus(ApproveStatus approveStatus);
}
