package fourservings_fiveservings.insurance_system_be.team.contract.common.entity.type;

import com.fasterxml.jackson.annotation.JsonValue;
import fourservings_fiveservings.insurance_system_be.common.exception.ResourceNotFoundException;
import fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType;
import java.util.EnumSet;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ApproveStatus {
    APPROVED("승인"),
    REJECTED("거부"),
    PENDING("대기");
    private final String name;

    public static ApproveStatus findByDescription(String name) {
        return EnumSet.allOf(ApproveStatus.class).stream()
            .filter(paymentMethod -> paymentMethod.getName().equals(name))
            .findFirst()
            .orElseThrow(() -> new ResourceNotFoundException(ErrorType.NO_EXIST_APPROVE_TYPE));
    }

    @JsonValue
    public String getName() {
        return this.name;
    }
}
