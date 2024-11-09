package fourservings_fiveservings.insurance_system_be.auth.controller;


import fourservings_fiveservings.insurance_system_be.auth.dto.request.SignInRequestDto;
import fourservings_fiveservings.insurance_system_be.auth.dto.request.SignUpRequestDto;
import fourservings_fiveservings.insurance_system_be.auth.jwt.dto.TokenDto;
import fourservings_fiveservings.insurance_system_be.auth.service.AuthService;
import fourservings_fiveservings.insurance_system_be.common.response.constant.SuccessType;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    public ApiResponse<?> signUp(@RequestBody SignUpRequestDto signUpRequestDto) {
        authService.signUp(signUpRequestDto);
        return ApiResponse.success(SuccessType.SUCCESS);
    }

    @GetMapping("/sign-in")
    public ApiResponse<?> signIn(@RequestBody SignInRequestDto signInRequestDto) {
        TokenDto token = authService.signIn(signInRequestDto);
        return ApiResponse.success(SuccessType.SUCCESS, token);
    }

}
