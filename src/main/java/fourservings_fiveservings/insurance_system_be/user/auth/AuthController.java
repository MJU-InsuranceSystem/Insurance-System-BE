package fourservings_fiveservings.insurance_system_be.user.auth;


import fourservings_fiveservings.insurance_system_be.common.view.SystemView;
import fourservings_fiveservings.insurance_system_be.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    public void signUp(@RequestBody SignUpRequest signUpRequest) {
        authService.signUp(signUpRequest);
    }
}
