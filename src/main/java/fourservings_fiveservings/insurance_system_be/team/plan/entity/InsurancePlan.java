package fourservings_fiveservings.insurance_system_be.team.plan.entity;

import fourservings_fiveservings.insurance_system_be.user.entity.Worker;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InsurancePlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String fileName;

    private InsuranceType insuranceType;

    private RequestStatus requestStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    private Worker worker;

    @Builder
    private InsurancePlan(String title, String description, InsuranceType insuranceType, String fileName, Worker worker) {
        this.title = title;
        this.description = description;
        this.fileName = fileName;
        this.worker = worker;
        this.insuranceType = insuranceType;
        requestStatus = RequestStatus.PENDING;
    }
}
