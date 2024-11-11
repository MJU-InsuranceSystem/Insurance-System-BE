package fourservings_fiveservings.insurance_system_be.team.product.controller;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.constant.SuccessType;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.team.product.api.ProductApi;
import fourservings_fiveservings.insurance_system_be.team.product.dto.DesignProductRequestDto;
import fourservings_fiveservings.insurance_system_be.team.product.entity.Product;
import fourservings_fiveservings.insurance_system_be.team.product.service.ProductService;
import fourservings_fiveservings.insurance_system_be.user.entity.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController implements ProductApi {

    private final ProductService productService;

    @Override
    public ApiResponse<?> designProduct(CustomUserDetails customUserDetails,
        DesignProductRequestDto designProductRequestDto) {
        User productDeveloper = customUserDetails.getUser();
        productService.designProduct(productDeveloper, designProductRequestDto);
        return ApiResponse.success(SuccessType.SUCCESS);
    }

    @Override
    public ApiResponse<?> getUnApprovedProducts() {
        List<Product> unapprovedProducts = productService.retrieveUnapprovedProducts();
        return ApiResponse.success(SuccessType.SUCCESS, unapprovedProducts);
    }


    @Override
    public ApiResponse<?> getApprovedProducts() {
        List<Product> approvedProduct = productService.retrieveApprovedProducts();
        return ApiResponse.success(SuccessType.SUCCESS, approvedProduct);
    }

    @Override
    public ApiResponse<?> approveProduct(CustomUserDetails customUserDetailsService,
        Long productId) {
        User approveWorker = customUserDetailsService.getUser();
        productService.approveProduct(approveWorker, productId);
        return ApiResponse.success(SuccessType.SUCCESS);
    }
}
