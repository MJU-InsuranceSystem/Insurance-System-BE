package fourservings_fiveservings.insurance_system_be.auth.controller;


import fourservings_fiveservings.insurance_system_be.auth.api.AuthApi;
import fourservings_fiveservings.insurance_system_be.auth.controller.dto.request.SignInRequestDto;
import fourservings_fiveservings.insurance_system_be.auth.controller.dto.request.SignUpRequestDto;
import fourservings_fiveservings.insurance_system_be.auth.jwt.dto.TokenDto;
import fourservings_fiveservings.insurance_system_be.auth.service.AuthService;
import fourservings_fiveservings.insurance_system_be.common.response.constant.SuccessType;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {

    private final AuthService authService;

    @Override
    public ApiResponse<?> signUp(SignUpRequestDto signUpRequestDto) {
        authService.signUp(signUpRequestDto);
        return ApiResponse.success(SuccessType.SUCCESS);
    }

    @Override
    public ApiResponse<?> signIn(SignInRequestDto signInRequestDto) {
        TokenDto token = authService.signIn(signInRequestDto);
        return ApiResponse.success(SuccessType.SUCCESS, token);
    }
}
