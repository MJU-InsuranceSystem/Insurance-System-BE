package fourservings_fiveservings.insurance_system_be.team.contract.car.entity.type;

import com.fasterxml.jackson.annotation.JsonValue;
import fourservings_fiveservings.insurance_system_be.common.exception.BusinessException;
import fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType;
import java.util.EnumSet;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LicenseType {
    CLASS1("1종 보통"),
    CLASS2("2종 보통"),
    FCHVDL("1종 대형");

    private final String description;

    public static LicenseType findByDescription(String description) {
        return EnumSet.allOf(LicenseType.class).stream()
            .filter(licenseType -> licenseType.getDescription().equals(description))
            .findFirst()
            .orElseThrow(() -> new BusinessException(ErrorType.RESOURCE_NOT_FOUND));
    }

    @JsonValue
    public String getDescription() {
        return this.description;
    }
}
