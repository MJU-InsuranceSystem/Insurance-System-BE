package fourservings_fiveservings.insurance_system_be.team.contract.common.controller;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.constant.SuccessType;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.team.contract.common.api.ContractApi;
import fourservings_fiveservings.insurance_system_be.team.contract.common.controller.dto.response.ContractListResponseDto;
import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.common.Contract;
import fourservings_fiveservings.insurance_system_be.team.contract.common.service.ContractService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommonContractController implements ContractApi {

    private final ContractService contractService;

    public ApiResponse<?> getUnApprovedContracts() {
        List<Contract> unApprovedContracts = contractService.getUnapprovedContracts();
        return ApiResponse.success(SuccessType.SUCCESS, unApprovedContracts);
    }

    public ApiResponse<?> getAllContracts() {
        List<ContractListResponseDto> contractList = contractService.getAllContracts();
        return ApiResponse.success(SuccessType.SUCCESS, contractList);
    }

    public ApiResponse<?> getContractListBySubscriberId(CustomUserDetails customUserDetails) {
        List<ContractListResponseDto> contractList = contractService.getContractListBySubscriber(
            customUserDetails.getCustom());
        return ApiResponse.success(SuccessType.SUCCESS, contractList);
    }
}
