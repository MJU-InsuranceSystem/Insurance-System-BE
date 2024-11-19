package fourservings_fiveservings.insurance_system_be.team.plan.entity;

import fourservings_fiveservings.insurance_system_be.common.exception.ResourceNotFoundException;
import fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType;
import java.util.Arrays;
import java.util.Objects;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InsuranceType {
    FIRE("화재보험"),
    CAR("자동차보험"),
    LIFE("생명보험");

    private final String name;

    public static InsuranceType findByName(String name) {
        return Arrays.stream(InsuranceType.values())
            .filter(insuranceType -> Objects.equals(insuranceType.getName(), name))
            .findFirst()
            .orElseThrow(() -> new ResourceNotFoundException(ErrorType.RESOURCE_NOT_FOUND));
    }
}
