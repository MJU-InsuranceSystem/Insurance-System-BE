package fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.entity;


import fourservings_fiveservings.insurance_system_be.common.entity.BaseEntity;
import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.common.Contract;
import fourservings_fiveservings.insurance_system_be.user.entity.Customer;
import fourservings_fiveservings.insurance_system_be.user.entity.Worker;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Accident extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime accidentDate;

    private String description;

    private String location;

    private BigDecimal damageAmount;

    private String fileName;

    private String comments;

    @Enumerated(EnumType.STRING)
    private AccidentType accidentType;

    @Enumerated(EnumType.STRING)
    private LiabilityStatus liabilityStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    private Contract contract;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Worker reviewer;

    @Builder
    private Accident(
        Long id, LocalDateTime accidentDate, String description,
        String location, BigDecimal damageAmount,
        String fileName, AccidentType accidentType, Contract contract,
        Customer customer
    ) {
        this.id = id;
        this.accidentDate = accidentDate;
        this.description = description;
        this.location = location;
        this.damageAmount = damageAmount;
        this.fileName = fileName;
        this.accidentType = accidentType;
        this.contract = contract;
        this.customer = customer;
        this.liabilityStatus = LiabilityStatus.PENDING;
    }

    public void updateReview(Worker reviewer, LiabilityStatus liabilityStatus, String comments) {
        this.reviewr = reviewer;
        this.liabilityStatus = liabilityStatus;
        this.comments = comments;
    }
}
