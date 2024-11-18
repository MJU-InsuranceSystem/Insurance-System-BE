package fourservings_fiveservings.insurance_system_be.user.controller;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.constant.SuccessType;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.user.api.UserApi;
import fourservings_fiveservings.insurance_system_be.user.controller.dto.request.SetAccountRequestDto;
import fourservings_fiveservings.insurance_system_be.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public ApiResponse<?> setAccount(CustomUserDetails customUserDetails, SetAccountRequestDto setAccountRequestDto) {
        userService.setAccount(customUserDetails, setAccountRequestDto);
        return ApiResponse.success(SuccessType.SUCCESS);
    }
}
