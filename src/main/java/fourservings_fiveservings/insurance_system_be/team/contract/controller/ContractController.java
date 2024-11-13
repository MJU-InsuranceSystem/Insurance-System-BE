package fourservings_fiveservings.insurance_system_be.team.contract.controller;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.constant.SuccessType;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.team.contract.api.ContractApi;
import fourservings_fiveservings.insurance_system_be.team.contract.service.ContractService;
import fourservings_fiveservings.insurance_system_be.user.entity.User;
import fourservings_fiveservings.insurance_system_be.team.contract.entity.Contract;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ContractController implements ContractApi {

    private final ContractService contractService;

    @Override
    public ApiResponse<?> joinInsurance(CustomUserDetails customUserDetails, Long productId) {
        User appliedCustomer = customUserDetails.getUser();
        contractService.processContract(appliedCustomer, productId);
        return ApiResponse.success(SuccessType.CREATED);
    }

    @Override
    public ApiResponse<?> getUnApprovedContracts() {
        List<Contract> unApprovedContracts = contractService.getUnapprovedContracts();
        return ApiResponse.success(SuccessType.SUCCESS, unApprovedContracts);
    }
}
