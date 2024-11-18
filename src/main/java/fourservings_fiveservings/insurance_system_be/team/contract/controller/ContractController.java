package fourservings_fiveservings.insurance_system_be.team.contract.controller;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.constant.SuccessType;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.team.contract.api.ContractApi;
import fourservings_fiveservings.insurance_system_be.team.contract.controller.dto.request.CarInsuranceJoinRequestDto;
import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.Contract;
import fourservings_fiveservings.insurance_system_be.team.contract.service.ContractService;
import fourservings_fiveservings.insurance_system_be.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ContractController implements ContractApi {

    private final ContractService contractService;

    @Override
    public ApiResponse<?> joinCarInsurance(CustomUserDetails customUserDetails,
        Long productId, CarInsuranceJoinRequestDto carInsuranceJoinRequestDto) {
        User appliedCustomer = customUserDetails.getCustom();
        contractService.processCarContract(appliedCustomer, productId, carInsuranceJoinRequestDto);
        return ApiResponse.success(SuccessType.CREATED);
    }

    @Override
    public ApiResponse<?> getUnApprovedContracts() {
        List<Contract> unApprovedContracts = contractService.getUnapprovedContracts();
        return ApiResponse.success(SuccessType.SUCCESS, unApprovedContracts);
    }
}
