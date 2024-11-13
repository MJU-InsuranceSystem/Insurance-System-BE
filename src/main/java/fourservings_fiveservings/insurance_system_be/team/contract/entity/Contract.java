package fourservings_fiveservings.insurance_system_be.team.contract.entity;

import fourservings_fiveservings.insurance_system_be.common.entity.BaseEntity;
import fourservings_fiveservings.insurance_system_be.team.product.entity.Product;
import fourservings_fiveservings.insurance_system_be.team.product.insurance.ApproveStatus;
import fourservings_fiveservings.insurance_system_be.user.entity.User;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Contract extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    private InsuranceApplication insuranceApplication;

    @Enumerated(EnumType.STRING)
    private ApproveStatus approveStatus;

    @ManyToOne
    private User subscriber;

    @ManyToOne
    private Product product;

    @ManyToOne
    private User underwriteManager;

    public static Contract fromUnApproveContract(User subscriber, Product product) {
        return Contract.builder()
            .subscriber(subscriber)
            .product(product)
            .approveStatus(ApproveStatus.UN_APPROVE)
            .build();
    }

    public void approveContract(User underwriteManager) {
        this.approveStatus = ApproveStatus.APPROVE;
        this.underwriteManager = underwriteManager;
    }

    //    @Override
//    public String toString() {
//        return "contract ID = " + id + "\n" +
//            "customer Name = " + customerName + '\n' +
//            "insurance ID = " + insuranceApplication.getInsuranceApplicationID() + '\n' +
//            "insurance Type = " + insuranceApplication.getInsurance().getInsuranceType() + '\n' +
//            "managerName = " + managerName;
//    }
}
