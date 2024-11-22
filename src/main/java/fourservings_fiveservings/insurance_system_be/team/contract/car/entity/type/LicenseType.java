package fourservings_fiveservings.insurance_system_be.team.contract.car.entity.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LicenseType {
    CLASS1("1종 보통"),
    CLASS2("2종 보통"),
    FCHVDL("1종 대형");

    private final String label;
}
