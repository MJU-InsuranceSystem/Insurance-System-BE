package fourservings_fiveservings.insurance_system_be.team.contract.common.entity.type;

import com.fasterxml.jackson.annotation.JsonValue;
import fourservings_fiveservings.insurance_system_be.common.exception.ResourceNotFoundException;
import fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType;
import java.util.EnumSet;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PaymentMethod {
    AUTO_PAYMENT("자동 이체"),
    DIRECT_PAYMENT("수동 이체");

    private final String description;

    public static PaymentMethod findByDescription(String description) {
        return EnumSet.allOf(PaymentMethod.class).stream()
            .filter(paymentMethod -> paymentMethod.getDescription().equals(description))
            .findFirst()
            .orElseThrow(() -> new ResourceNotFoundException(ErrorType.NO_EXIST_PAYMENT_METHOD));
    }

    @JsonValue
    public String getDescription() {
        return this.description;
    }
}
