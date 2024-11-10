package fourservings_fiveservings.insurance_system_be.team.contract.controller;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.constant.SuccessType;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.domain.user.entity.User;
import fourservings_fiveservings.insurance_system_be.team.contract.api.ContractApi;
import fourservings_fiveservings.insurance_system_be.team.contract.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ContractController implements ContractApi {

    private final ContractService contractService;

    @Override
    public ApiResponse<?> applyProduct(CustomUserDetails customUserDetails, Long productId) {
        User appliedCustomer = customUserDetails.getUser();
        contractService.processContract(appliedCustomer, productId);
        return ApiResponse.success(SuccessType.CREATED);
    }
}
