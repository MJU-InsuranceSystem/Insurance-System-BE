package fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.entity;


import fourservings_fiveservings.insurance_system_be.common.entity.BaseEntity;
import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.common.Contract;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.entity.enums.AccidentType;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.entity.enums.LiabilityStatus;
import fourservings_fiveservings.insurance_system_be.user.entity.Customer;
import fourservings_fiveservings.insurance_system_be.user.entity.Worker;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Accident extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

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

    public void updateReview(Worker reviewer, LiabilityStatus liabilityStatus, String comments) {
        this.reviewer = reviewer;
        this.liabilityStatus = liabilityStatus;
        this.comments = comments;
    }
}
