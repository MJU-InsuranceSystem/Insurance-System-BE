package fourservings_fiveservings.insurance_system_be.team.product.entity;

import fourservings_fiveservings.insurance_system_be.common.entity.BaseEntity;
import fourservings_fiveservings.insurance_system_be.domain.insurance.ApproveStatus;
import fourservings_fiveservings.insurance_system_be.domain.user.entity.User;
import fourservings_fiveservings.insurance_system_be.team.plan.design.model.SaleTarget;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
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

    @Enumerated(EnumType.STRING)
    private ApproveStatus approveStatus;

    @ManyToOne
    private User underwriter;

    @ManyToOne
    private User productDeveloper;

    @Builder
    public Product(
        String productTitle, String productOutline,
        SaleTarget saleTarget, Integer monthlyPaymentAmount,
        String rewardDetails, String strategy, ApproveStatus approveStatus, User productDeveloper) {
        this.productTitle = productTitle;
        this.productOutline = productOutline;
        this.saleTarget = saleTarget;
        this.monthlyPaymentAmount = monthlyPaymentAmount;
        this.rewardDetails = rewardDetails;
        this.strategy = strategy;
        this.approveStatus = approveStatus;
        this.productDeveloper = productDeveloper;
        this.underwriter = null;
    }

    public void approveProduct(User underwriter) {
        this.approveStatus = ApproveStatus.APPROVE;
        this.underwriter = underwriter;
    }
}
