package fourservings_fiveservings.insurance_system_be.team.product.entity;

import fourservings_fiveservings.insurance_system_be.common.entity.BaseEntity;
import fourservings_fiveservings.insurance_system_be.team.plan.design.model.SaleTarget;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productTitle;

    private String productOutline;

    @Enumerated(EnumType.STRING)
    private SaleTarget saleTarget;

    private Integer monthlyPaymentAmount;

    private String rewardDetails;

    private String strategy;

    private ApproveStatus approveStatus;


    @Builder
    public Product(
        String productTitle, String productOutline,
        SaleTarget saleTarget, Integer monthlyPaymentAmount,
        String rewardDetails, String strategy, ApproveStatus approveStatus) {
        this.productTitle = productTitle;
        this.productOutline = productOutline;
        this.saleTarget = saleTarget;
        this.monthlyPaymentAmount = monthlyPaymentAmount;
        this.rewardDetails = rewardDetails;
        this.strategy = strategy;
        this.approveStatus = approveStatus;
    }

    public void approveProduct() {
        this.approveStatus = ApproveStatus.APPROVE;
    }
}
