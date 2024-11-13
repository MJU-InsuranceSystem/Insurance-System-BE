package fourservings_fiveservings.insurance_system_be.team.product.controller.dto;


import fourservings_fiveservings.insurance_system_be.team.product.insurance.ApproveStatus;
import fourservings_fiveservings.insurance_system_be.team.product.entity.Product;
import fourservings_fiveservings.insurance_system_be.user.entity.User;
import fourservings_fiveservings.insurance_system_be.team.plan.design.model.SaleTarget;

public record DesignProductRequestDto(
    // 상품 제목, 상품 개요, 판매 대상, 매달 보험료, 보상 내용, 전략,
    String productTitle,
    String overview,
    SaleTarget saleTarget,
    Integer monthlyPaymentAmount,
    String rewardDetails,
    String saleStrategy
) {

    public Product toProduct(User productDeveloper) {
        return Product.builder()
            .productTitle(productTitle)
            .overview(overview)
            .saleTarget(saleTarget)
            .monthlyPaymentAmount(monthlyPaymentAmount)
            .rewardDetails(rewardDetails)
            .saleStrategy(saleStrategy)
            .approveStatus(ApproveStatus.UN_APPROVE)
            .productDeveloper(productDeveloper)
            .build();
    }
}
