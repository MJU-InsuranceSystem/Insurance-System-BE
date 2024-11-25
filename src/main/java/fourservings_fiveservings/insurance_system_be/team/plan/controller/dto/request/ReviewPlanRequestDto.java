package fourservings_fiveservings.insurance_system_be.team.plan.controller.dto.request;

import fourservings_fiveservings.insurance_system_be.team.plan.entity.type.ReviewStatus;

public record ReviewPlanRequestDto(
    String reviewResult,
    String comments
) {

    public ReviewStatus getReviewStatus() {
        return ReviewStatus.valueOf(reviewResult);
    }
}
