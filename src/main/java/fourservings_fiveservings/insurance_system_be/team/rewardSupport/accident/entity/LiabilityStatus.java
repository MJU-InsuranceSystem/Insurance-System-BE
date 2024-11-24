package fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.entity;

import fourservings_fiveservings.insurance_system_be.common.exception.ResourceNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

import static fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType.RESOURCE_NOT_FOUND;

@Getter
@RequiredArgsConstructor
public enum LiabilityStatus {

    EXEMPTION("면책"),
    IMPOSITION("부책"),
    PENDING("대기중");

    private final String description;

    public static LiabilityStatus findByDescription(String description) {
        return Arrays.stream(LiabilityStatus.values())
            .filter(liabilityStatus -> Objects.equals(liabilityStatus.getDescription(), description))
            .findFirst()
            .orElseThrow(() -> new ResourceNotFoundException(RESOURCE_NOT_FOUND));
    }
}
