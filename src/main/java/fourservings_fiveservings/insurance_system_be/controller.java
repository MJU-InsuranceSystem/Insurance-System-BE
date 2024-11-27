package fourservings_fiveservings.insurance_system_be;

import fourservings_fiveservings.insurance_system_be.common.response.constant.SuccessType;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller {

    @GetMapping("/health")
    public ApiResponse<?> serverCheck() {
        return ApiResponse.success(SuccessType.SUCCESS);
    }
}
