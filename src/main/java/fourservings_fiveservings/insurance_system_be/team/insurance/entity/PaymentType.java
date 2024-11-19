package fourservings_fiveservings.insurance_system_be.team.insurance.entity;

import fourservings_fiveservings.insurance_system_be.common.exception.ResourceNotFoundException;
import fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType;
import java.util.Arrays;
import java.util.Objects;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentType {
    MONTH("월별"),
    YEAR("연별");

    private final String description;

    public static PaymentType findByDescription(String description) {
        return Arrays.stream(PaymentType.values())
            .filter(paymentType -> Objects.equals(paymentType.getDescription(), description))
            .findFirst()
            .orElseThrow(() -> new ResourceNotFoundException(ErrorType.RESOURCE_NOT_FOUND));
    }
}
