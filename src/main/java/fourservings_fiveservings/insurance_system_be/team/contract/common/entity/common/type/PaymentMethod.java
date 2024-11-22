package fourservings_fiveservings.insurance_system_be.team.contract.common.entity.common.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentMethod {
    AUTO_PAYMENT("자동 이체"),
    DIRECT_PAYMENT("수동");

    private final String label;
}
