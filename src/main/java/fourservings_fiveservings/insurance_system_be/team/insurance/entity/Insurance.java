package fourservings_fiveservings.insurance_system_be.team.insurance.entity;

import fourservings_fiveservings.insurance_system_be.common.entity.BaseEntity;
import fourservings_fiveservings.insurance_system_be.team.insurance.entity.type.InsuranceType;
import fourservings_fiveservings.insurance_system_be.team.insurance.entity.type.SaleTarget;
import fourservings_fiveservings.insurance_system_be.user.entity.Worker;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Insurance extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private int eligibleAgeMin;

    private int eligibleAgeMax;

    private String coverageRange;

    private BigDecimal coverageAmountMax;

    private int duration;

    private String exclusions;

    private BigDecimal monthlyPremium;

    private LocalDate salesStartDate;

    private LocalDate salesEndDate;

    @Enumerated(EnumType.STRING)
    private SaleTarget saleTarget;

    @Enumerated(EnumType.STRING)
    private InsuranceType insuranceType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Worker worker;

    @Builder
    private Insurance(
        String name, String description, int eligibleAgeMin, int eligibleAgeMax,
        String coverageRange, BigDecimal coverageAmountMax, int duration, String exclusions,
        BigDecimal monthlyPremium, LocalDate salesStartDate, LocalDate salesEndDate,
        SaleTarget saleTarget, InsuranceType insuranceType, Worker worker
    ) {
        this.name = name;
        this.description = description;
        this.eligibleAgeMin = eligibleAgeMin;
        this.eligibleAgeMax = eligibleAgeMax;
        this.coverageRange = coverageRange;
        this.coverageAmountMax = coverageAmountMax;
        this.duration = duration;
        this.exclusions = exclusions;
        this.monthlyPremium = monthlyPremium;
        this.salesStartDate = salesStartDate;
        this.salesEndDate = salesEndDate;
        this.saleTarget = saleTarget;
        this.insuranceType = insuranceType;
        this.worker = worker;
    }
}
