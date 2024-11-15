package fourservings_fiveservings.insurance_system_be.team.contract.entity.common.type;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PaymentMethod {
    AUTO("자동 이체"),
    MANUAL("수동");

    private final String label;
}
