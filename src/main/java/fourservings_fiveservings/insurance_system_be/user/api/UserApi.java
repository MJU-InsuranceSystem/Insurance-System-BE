package fourservings_fiveservings.insurance_system_be.user.api;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.user.controller.dto.request.SetAccountRequestDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/users", produces = "application/json;charset=utf-8")
public interface UserApi {

    @PostMapping
    ApiResponse<?> setAccount(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                              @RequestBody SetAccountRequestDto setAccountRequestDto);


}
