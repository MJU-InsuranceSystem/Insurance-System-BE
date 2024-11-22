package fourservings_fiveservings.insurance_system_be.file.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FIleType {
    INSURANCE_PLAN("plan"),
    ACCIDENT("accident");

    private final String label;
}
