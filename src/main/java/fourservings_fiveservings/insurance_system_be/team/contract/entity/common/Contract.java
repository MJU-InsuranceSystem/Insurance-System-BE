package fourservings_fiveservings.insurance_system_be.team.contract.entity.common;

import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.embaded.ContractInformation;
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
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public abstract class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // 1 = 1일
    @Embedded
    ContractInformation contractInformation;

    @Enumerated(EnumType.STRING)
    private ApproveStatus approveStatus;

    @ManyToOne
    private User subscriber;

    @ManyToOne
    private Product product;

    @ManyToOne
    private User underwriteManager;

    public void approveContract(User underwriteManager) {
        this.approveStatus = ApproveStatus.APPROVE;
        this.underwriteManager = underwriteManager;
    }
}
