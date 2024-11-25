package fourservings_fiveservings.insurance_system_be.team.insurance.entity.type;

import fourservings_fiveservings.insurance_system_be.common.exception.ResourceNotFoundException;
import fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType;
import java.util.Arrays;
import java.util.Objects;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SaleTarget {
    YOUNG("청년층"),
    MIDDLE_AGED("중년층"),
    OLDER("노년층");

    private final String description;

    public static SaleTarget findByDescription(String description) {
        return Arrays.stream(SaleTarget.values())
            .filter(saleTarget -> Objects.equals(saleTarget.getDescription(), description))
            .findFirst()
            .orElseThrow(() -> new ResourceNotFoundException(ErrorType.RESOURCE_NOT_FOUND));
    }
}
