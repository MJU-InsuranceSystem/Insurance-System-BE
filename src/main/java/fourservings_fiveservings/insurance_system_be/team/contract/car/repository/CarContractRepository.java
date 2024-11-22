package fourservings_fiveservings.insurance_system_be.team.contract.car.repository;

import fourservings_fiveservings.insurance_system_be.team.contract.car.entity.CarContract;
import fourservings_fiveservings.insurance_system_be.user.entity.Customer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarContractRepository extends JpaRepository<CarContract, Long> {


    Optional<CarContract> findByIdAndSubscriber(Long contractId, Customer custom);
}
