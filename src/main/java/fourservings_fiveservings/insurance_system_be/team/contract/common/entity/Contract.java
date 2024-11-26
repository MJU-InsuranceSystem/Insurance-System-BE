package fourservings_fiveservings.insurance_system_be.team.contract.common.entity;

import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.embaded.ContractInformation;
import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.type.ApproveStatus;
import fourservings_fiveservings.insurance_system_be.team.insurance.entity.Insurance;
import fourservings_fiveservings.insurance_system_be.user.entity.Customer;
import fourservings_fiveservings.insurance_system_be.user.entity.Worker;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
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
    private Long id;

    // 1 = 1일
    @Embedded
    private ContractInformation contractInformation;

    @Enumerated(EnumType.STRING)
    private ApproveStatus approveStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer subscriber;

    @ManyToOne(fetch = FetchType.LAZY)
    private Insurance insurance;

    @ManyToOne(fetch = FetchType.LAZY)
    private Worker underwriteManager;

    public void updateApproveStatus(Worker underwriteManager, ApproveStatus approveStatus) {
        this.approveStatus = approveStatus;
        this.underwriteManager = underwriteManager;
    }
}
