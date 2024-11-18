package fourservings_fiveservings.insurance_system_be.user.controller.dto.request;

public record SetAccountRequestDto(
        String bankName,
        String accountNumber,
        int balance
) {
}
