package fourservings_fiveservings.insurance_system_be.team.product.api;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.team.product.dto.DesignProductRequestDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/products", produces = "application/json;charset=utf-8")
public interface ProductApi {

    // 상품 기획 하기
    // 등록한 상품기획 조회하기 <- 아직 허가 안됌.
    // 상품 기획안 허락하기,
    // 상품 등록하기? 흠
    @PostMapping()
    ApiResponse<?> designProduct(@AuthenticationPrincipal CustomUserDetails customUserDetails,
        @RequestBody DesignProductRequestDto designProductRequestDto);

    @GetMapping("/un-approved")
    ApiResponse<?> getUnApprovedProducts();

    @GetMapping("/approved")
    ApiResponse<?> getApprovedProducts();

    @PatchMapping("/{productId}")
    ApiResponse<?> approveProduct(@AuthenticationPrincipal CustomUserDetails customUserDetails,
        @PathVariable(name = "productId") Long productId);
}
