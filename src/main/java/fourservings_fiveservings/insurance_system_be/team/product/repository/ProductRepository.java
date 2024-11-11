package fourservings_fiveservings.insurance_system_be.team.product.repository;


import fourservings_fiveservings.insurance_system_be.team.product.insurance.ApproveStatus;
import fourservings_fiveservings.insurance_system_be.team.product.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByApproveStatus(ApproveStatus approveStatus);

}
