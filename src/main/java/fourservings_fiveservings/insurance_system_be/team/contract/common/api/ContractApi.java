package fourservings_fiveservings.insurance_system_be.team.contract.common.api;


import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/contracts", produces = "application/json;charset=utf-8")
public interface ContractApi {

    @GetMapping("/un-approved")
    ApiResponse<?> getUnApprovedContracts();

    @GetMapping
    ApiResponse<?> getAllContracts();

    @GetMapping("/subscriber/{subscriber-id}")
    ApiResponse<?> getContractListBySubscriberId(
        @PathVariable(value = "subscriber-id") Long subscriberId);
}
