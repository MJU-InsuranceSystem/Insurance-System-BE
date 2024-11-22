package fourservings_fiveservings.insurance_system_be.team.contract.common.controller.dto.response;

import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.common.ApproveStatus;
import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.common.Contract;
import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.common.embaded.ContractInformation;
import lombok.Builder;

@Builder
public record ContractListResponseDto(
    Long contractId,
    ApproveStatus approveStatus,
    ContractInformation contractInformation
) {

    public static ContractListResponseDto of(Contract contract) {
        return ContractListResponseDto.builder()
            .contractId(contract.getId())
            .contractInformation(contract.getContractInformation())
            .approveStatus(contract.getApproveStatus())
            .build();
    }
}
