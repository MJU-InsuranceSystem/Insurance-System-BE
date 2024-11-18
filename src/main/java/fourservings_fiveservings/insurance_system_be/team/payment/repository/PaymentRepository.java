package fourservings_fiveservings.insurance_system_be.team.payment.repository;

import fourservings_fiveservings.insurance_system_be.team.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
