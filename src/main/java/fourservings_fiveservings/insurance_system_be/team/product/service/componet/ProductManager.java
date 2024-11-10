package fourservings_fiveservings.insurance_system_be.team.product.service.componet;

import fourservings_fiveservings.insurance_system_be.team.product.entity.Product;
import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductManager {

    public Product checkProduct(Optional<Product> optionalProduct) {
        return optionalProduct.orElseThrow(EntityNotFoundException::new);
    }
}
