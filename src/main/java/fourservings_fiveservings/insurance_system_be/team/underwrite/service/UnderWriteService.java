package fourservings_fiveservings.insurance_system_be.team.underwrite.service;

import fourservings_fiveservings.insurance_system_be.domain.user.entity.User;
import fourservings_fiveservings.insurance_system_be.team.product.entity.Product;
import fourservings_fiveservings.insurance_system_be.team.product.repository.ProductRepository;
import fourservings_fiveservings.insurance_system_be.team.product.service.componet.ProductManager;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UnderWriteService {

    private final ProductManager productManager;
    private final ProductRepository productRepository;

    public void approveProduct(User underwriter, Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        Product product = productManager.checkProduct(optionalProduct);
        product.approveProduct(underwriter);
    }
}
