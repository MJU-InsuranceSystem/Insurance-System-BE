package fourservings_fiveservings.insurance_system_be.team.product.controller.dto;


import fourservings_fiveservings.insurance_system_be.team.plan.design.model.SaleTarget;
import fourservings_fiveservings.insurance_system_be.team.product.entity.ApproveStatus;
import fourservings_fiveservings.insurance_system_be.team.product.entity.Product;

public record DesignProductRequest(
    // 상품 제목, 상품 개요, 판매 대상, 매달 보험료, 보상 내용, 전략,
    String productTitle, String productOutline,
    SaleTarget saleTarget, Integer monthlyPaymentAmount,
    String rewardDetails, String strategy
) {

    public Product toProduct() {
        return Product.builder()
            .productTitle(productTitle)
            .productOutline(productOutline)
            .saleTarget(saleTarget)
            .monthlyPaymentAmount(monthlyPaymentAmount)
            .rewardDetails(rewardDetails)
            .strategy(strategy)
            .approveStatus(ApproveStatus.WAIT_APPROVE)
            .build();
    }
}
