package fourservings_fiveservings.insurance_system_be.team.contract.common.controller.dto.response;

import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.Contract;
import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.embaded.ContractInformation;
import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.type.ApproveStatus;
import lombok.Builder;

@Builder
public record ContractListResponseDto(
    Long contractId,
    String insuranceName,
    ApproveStatus approveStatus,
    ContractInformation contractInformation
) {

    public static ContractListResponseDto of(Contract contract) {
        return ContractListResponseDto.builder()
            .contractId(contract.getId())
            .insuranceName(contract.getInsuranceName())
            .contractInformation(contract.getContractInformation())
            .approveStatus(contract.getApproveStatus())
            .build();
    }
}
