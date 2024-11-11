package fourservings_fiveservings.insurance_system_be.team.contract.entity;

import fourservings_fiveservings.insurance_system_be.common.entity.BaseEntity;
import fourservings_fiveservings.insurance_system_be.domain.insurance.ApproveStatus;
import fourservings_fiveservings.insurance_system_be.domain.user.entity.User;
import fourservings_fiveservings.insurance_system_be.team.product.entity.Product;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Contract extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    @Embedded
    private InsuranceApplication insuranceApplication;

    @Enumerated(EnumType.STRING)
    private ApproveStatus approveStatus;

    public static Contract fromUnApproveContract(User appliedCustomer, Product product) {
        return Contract.builder()
            .user(appliedCustomer)
            .product(product)
            .approveStatus(ApproveStatus.UN_APPROVE)
            .build();
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