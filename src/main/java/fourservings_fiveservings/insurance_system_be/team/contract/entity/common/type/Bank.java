package fourservings_fiveservings.insurance_system_be.team.contract.entity.common.type;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Bank {
    KB("국민은행"),
    IBK("기업은행");

    private final String label;

}
