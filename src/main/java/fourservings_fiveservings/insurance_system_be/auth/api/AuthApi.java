package fourservings_fiveservings.insurance_system_be.auth.api;

import fourservings_fiveservings.insurance_system_be.auth.controller.dto.request.SignInRequestDto;
import fourservings_fiveservings.insurance_system_be.auth.controller.dto.request.SignUpRequestDto;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/auth", produces = "application/json;charset=utf-8")
public interface AuthApi {

    @PostMapping("/sign-up")
    ApiResponse<?> signUp(@RequestBody SignUpRequestDto signUpRequestDto);

    @PostMapping("/sign-in")
    ApiResponse<?> signIn(@RequestBody SignInRequestDto signInRequestDto);
}
