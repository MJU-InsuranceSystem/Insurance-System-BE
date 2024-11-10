package fourservings_fiveservings.insurance_system_be.team.product.service;

import fourservings_fiveservings.insurance_system_be.domain.user.entity.User;
import fourservings_fiveservings.insurance_system_be.team.product.controller.dto.DesignProductRequest;
import fourservings_fiveservings.insurance_system_be.team.product.entity.ApproveStatus;
import fourservings_fiveservings.insurance_system_be.team.product.entity.Product;
import fourservings_fiveservings.insurance_system_be.team.product.repository.ProductRepository;
import fourservings_fiveservings.insurance_system_be.team.product.service.componet.ProductManager;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductManager productManager;

    @Transactional
    public void designProduct(User productDeveloper, DesignProductRequest designProductRequest) {
        Product product = designProductRequest.toProduct(productDeveloper);
        productRepository.save(product);
    }

    public List<Product> retrieveUnapprovedProducts() {
        List<Product> unapprovedProducts = productRepository.findByApproveStatus(
            ApproveStatus.UN_APPROVE);
        return unapprovedProducts;
    }

    public void approveProduct(User underwriter, Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        Product product = productManager.checkProduct(optionalProduct);
        product.approveProduct(underwriter);
    }
}
