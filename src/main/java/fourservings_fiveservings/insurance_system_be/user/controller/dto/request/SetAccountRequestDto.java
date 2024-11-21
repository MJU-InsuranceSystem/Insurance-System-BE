package fourservings_fiveservings.insurance_system_be.user.controller.dto.request;

import java.math.BigDecimal;

public record SetAccountRequestDto(
        String bankName,
        String accountNumber,
        BigDecimal balance
) {
}
