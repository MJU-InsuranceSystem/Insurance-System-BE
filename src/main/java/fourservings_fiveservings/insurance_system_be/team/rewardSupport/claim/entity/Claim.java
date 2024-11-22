package fourservings_fiveservings.insurance_system_be.team.rewardSupport.claim.entity;

import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.entity.Accident;
import fourservings_fiveservings.insurance_system_be.user.entity.Worker;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal paymentAmount;

    private String comments;

    @ManyToOne
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
