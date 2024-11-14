package fourservings_fiveservings.insurance_system_be.auth.controller.dto.request;

public record SignInRequestDto(
        String email,
        String password
) {
}
