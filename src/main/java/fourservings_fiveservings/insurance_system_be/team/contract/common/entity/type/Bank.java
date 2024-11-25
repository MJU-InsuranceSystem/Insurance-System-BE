package fourservings_fiveservings.insurance_system_be.team.contract.common.entity.type;

import com.fasterxml.jackson.annotation.JsonValue;
import fourservings_fiveservings.insurance_system_be.common.exception.BusinessException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType.INVALID_BANK_NAME;

@Getter
@RequiredArgsConstructor
public enum Bank {
    KB("국민은행"),
    IBK("기업은행"),
    KEB("하나은행"),
    NH("농협은행"),
    SH("신한은행"),
    WOORI("우리은행"),
    KAKAO("카카오뱅크"),
    TOSS("토스뱅크");

    private final String name;

    public static Bank fromName(String bankName) {
        for (Bank bank : Bank.values()) {
            if (bank.getName().equals(bankName)) {
                return bank;
            }
        }
        throw new BusinessException(INVALID_BANK_NAME);
    }

    @JsonValue
    public String getName() {
        return this.name;
    }
}
