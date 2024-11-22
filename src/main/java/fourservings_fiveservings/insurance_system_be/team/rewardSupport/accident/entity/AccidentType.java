package fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.entity;

import fourservings_fiveservings.insurance_system_be.common.exception.ResourceNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

import static fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType.RESOURCE_NOT_FOUND;

@Getter
@RequiredArgsConstructor
public enum AccidentType {
    FIRE("화재 사고"),
    CAR("자동차 사고"),
    THEFT("도난 사고"),
    MEDICAL("의료 사고"),
    NATURAL_DISASTER("자연재해"),
    LIABILITY("책임 배상"),
    WORKPLACE("산재 사고"),
    OTHER("기타");

    private final String name;

    public static AccidentType findByName(String name) {
        return Arrays.stream(AccidentType.values())
                .filter(accidentType -> Objects.equals(accidentType.getName(), name))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException(RESOURCE_NOT_FOUND));
    }
}
