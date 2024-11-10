package fourservings_fiveservings.insurance_system_be.team.product.controller;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.constant.SuccessType;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.domain.user.entity.User;
import fourservings_fiveservings.insurance_system_be.team.product.api.ProductApi;
import fourservings_fiveservings.insurance_system_be.team.product.controller.dto.DesignProductRequest;
import fourservings_fiveservings.insurance_system_be.team.product.entity.Product;
import fourservings_fiveservings.insurance_system_be.team.product.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController implements ProductApi {

    private final ProductService productService;

    @Override
    public ApiResponse<?> designProduct(CustomUserDetails customUserDetails,
        DesignProductRequest designProductRequest) {
        User productDeveloper = customUserDetails.getUser();
        productService.designProduct(productDeveloper, designProductRequest);
        return ApiResponse.success(SuccessType.SUCCESS);
    }

    @Override
    public ApiResponse<?> getUnapprovedProducts() {
        List<Product> unapprovedProducts = productService.retrieveUnapprovedProducts();
        return ApiResponse.success(SuccessType.SUCCESS, unapprovedProducts);
    }


    @Override
    public ApiResponse<?> getApprovedProducts() {
        List<Product> approvedProduct = productService.retrieveApprovedProducts();
        return ApiResponse.success(SuccessType.SUCCESS, approvedProduct);
    }
}
