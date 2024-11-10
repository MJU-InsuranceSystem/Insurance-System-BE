package fourservings_fiveservings.insurance_system_be.team.product.service.componet;

import fourservings_fiveservings.insurance_system_be.team.product.entity.Product;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductManager {

    public Product checkProduct(Optional<Product> optionalProduct) {
        return optionalProduct.orElseThrow(EntityNotFoundException::new);
    }
}
