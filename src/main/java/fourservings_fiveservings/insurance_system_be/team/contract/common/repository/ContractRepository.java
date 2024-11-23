package fourservings_fiveservings.insurance_system_be.team.contract.common.repository;

import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.common.ApproveStatus;
import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.common.Contract;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {

    List<Contract> findByApproveStatus(ApproveStatus approveStatus);

    List<Contract> findBySubscriberId(Long subscriberId);
}
