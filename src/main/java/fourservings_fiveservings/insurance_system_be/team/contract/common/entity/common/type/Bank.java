package fourservings_fiveservings.insurance_system_be.team.contract.common.entity.common.type;

import static fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType.INVALID_BANK_NAME;

import com.fasterxml.jackson.annotation.JsonValue;
import fourservings_fiveservings.insurance_system_be.common.exception.BusinessException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Bank {
    KB("국민은행"),
    IBK("기업은행");

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
