package fourservings_fiveservings.insurance_system_be.team.product.entity;

import fourservings_fiveservings.insurance_system_be.common.entity.BaseEntity;
import fourservings_fiveservings.insurance_system_be.team.product.insurance.ApproveStatus;
import fourservings_fiveservings.insurance_system_be.user.entity.User;
import fourservings_fiveservings.insurance_system_be.team.plan.design.model.SaleTarget;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productTitle;

    private String overview;

    @Enumerated(EnumType.STRING)
    private SaleTarget saleTarget;

    private int monthlyPaymentAmount;

    private String rewardDetails;

    private String saleStrategy;

    @Enumerated(EnumType.STRING)
    private ApproveStatus approveStatus;

    @ManyToOne
    private User approveWorker;

    @ManyToOne
    private User productDeveloper;

    public void approveProduct(User underwriter) {
        this.approveStatus = ApproveStatus.APPROVE;
        this.approveWorker = underwriter;
    }
}
