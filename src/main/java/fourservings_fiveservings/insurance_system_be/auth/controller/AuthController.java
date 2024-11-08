package fourservings_fiveservings.insurance_system_be.auth.controller;


import fourservings_fiveservings.insurance_system_be.auth.dto.request.SignInRequestDto;
import fourservings_fiveservings.insurance_system_be.auth.jwt.dto.TokenDto;
import fourservings_fiveservings.insurance_system_be.auth.service.AuthService;
import fourservings_fiveservings.insurance_system_be.auth.dto.request.SignUpRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequestDto signUpRequestDto) {
        authService.signUp(signUpRequestDto);
        return ResponseEntity.ok().body("회원가입 완료");
    }

    @GetMapping("/sign-in")
    public ResponseEntity<TokenDto> signIn(@RequestBody SignInRequestDto signInRequestDto) {
        return ResponseEntity.ok().body(authService.signIn(signInRequestDto));
    }

}
