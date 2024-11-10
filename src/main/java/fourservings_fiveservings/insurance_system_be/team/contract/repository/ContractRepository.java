package fourservings_fiveservings.insurance_system_be.team.contract.repository;

import fourservings_fiveservings.insurance_system_be.team.contract.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Integer> {

}
