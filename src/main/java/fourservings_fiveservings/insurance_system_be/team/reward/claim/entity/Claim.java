package fourservings_fiveservings.insurance_system_be.team.reward.claim.entity;

import fourservings_fiveservings.insurance_system_be.common.entity.BaseEntity;
import fourservings_fiveservings.insurance_system_be.team.reward.accident.entity.Accident;
import fourservings_fiveservings.insurance_system_be.user.entity.Worker;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Claim extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal paymentAmount;

    private String comments;

    @ManyToOne(fetch = FetchType.LAZY)
    private Worker worker;

    @OneToOne
    @JoinColumn(name = "accident_id", unique = true, nullable = false)
    private Accident accident;

    @Builder
    private Claim(Long id, BigDecimal paymentAmount, String comments, Accident accident, Worker worker) {
        this.id = id;
        this.paymentAmount = paymentAmount;
        this.comments = comments;
        this.accident = accident;
        this.worker = worker;
    }
}
