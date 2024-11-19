package fourservings_fiveservings.insurance_system_be.team.plan.entity;

import fourservings_fiveservings.insurance_system_be.common.entity.BaseEntity;
import fourservings_fiveservings.insurance_system_be.user.entity.Worker;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InsurancePlan extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String fileName;

    private String comments;

    @Enumerated(EnumType.STRING)
    private InsuranceType insuranceType;

    @Enumerated(EnumType.STRING)
    private ReviewStatus reviewStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planner_id")
    private Worker planner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewer_id")
    private Worker reviewer;

    @Builder
    private InsurancePlan(String title, String description, InsuranceType insuranceType, String fileName, Worker planner, Worker reviewer) {
        this.title = title;
        this.description = description;
        this.fileName = fileName;
        this.planner = planner;
        this.insuranceType = insuranceType;
        this.reviewer = reviewer;
        this.reviewStatus = ReviewStatus.PENDING;
    }

    public void updateReview(Worker reviewer, ReviewStatus reviewStatus, String comments) {
        this.reviewer = reviewer;
        this.reviewStatus = reviewStatus;
        this.comments = comments;
    }
}
