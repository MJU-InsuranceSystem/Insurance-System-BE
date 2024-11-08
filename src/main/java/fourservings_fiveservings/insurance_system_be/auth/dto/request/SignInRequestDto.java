package fourservings_fiveservings.insurance_system_be.auth.dto.request;

public record SignInRequestDto(
        String email,
        String password
) {
}
