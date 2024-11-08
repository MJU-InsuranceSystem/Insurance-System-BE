package fourservings_fiveservings.insurance_system_be.team.product.service;

import fourservings_fiveservings.insurance_system_be.team.product.controller.dto.DesignProductRequest;
import fourservings_fiveservings.insurance_system_be.team.product.entity.ApproveStatus;
import fourservings_fiveservings.insurance_system_be.team.product.entity.Product;
import fourservings_fiveservings.insurance_system_be.team.product.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public void designProduct(DesignProductRequest designProductRequest) {
        Product product = designProductRequest.toProduct();
        productRepository.save(product);
    }

    public List<Product> retrieveUnapprovedProducts() {
        List<Product> unapprovedProducts = productRepository.findByApproveStatus(
            ApproveStatus.UN_APPROVE);
        return unapprovedProducts;
    }
}
