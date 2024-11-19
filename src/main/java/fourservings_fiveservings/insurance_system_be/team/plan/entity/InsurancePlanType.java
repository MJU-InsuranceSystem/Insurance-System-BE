package fourservings_fiveservings.insurance_system_be.team.plan.entity;

import fourservings_fiveservings.insurance_system_be.common.exception.ResourceNotFoundException;
import fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType;
import java.util.Arrays;
import java.util.Objects;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InsurancePlanType {
    FIRE("화재보험"),
    CAR("자동차보험"),
    LIFE("생명보험"),
    HEALTH("건강보험"),
    TRAVEL("여행보험"),
    CANCER("암보험");

    private final String name;

    public static InsurancePlanType findByName(String name) {
        return Arrays.stream(InsurancePlanType.values())
            .filter(insuranceType -> Objects.equals(insuranceType.getName(), name))
            .findFirst()
            .orElseThrow(() -> new ResourceNotFoundException(ErrorType.RESOURCE_NOT_FOUND));
    }
}
