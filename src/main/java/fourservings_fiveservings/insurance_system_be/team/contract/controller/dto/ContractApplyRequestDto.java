package fourservings_fiveservings.insurance_system_be.team.contract.controller.dto;

import fourservings_fiveservings.insurance_system_be.team.contract.entity.car.CarContract;
import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.ApproveStatus;
import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.Contract;
import fourservings_fiveservings.insurance_system_be.team.insurance.entity.Insurance;
import fourservings_fiveservings.insurance_system_be.user.entity.User;

public record ContractApplyRequestDto(

) {

    public static Contract toEntity(User appliedCustomer, Insurance insurance) {
        return CarContract.builder()
            .subscriber(appliedCustomer)
            .insurance(insurance)
            .approveStatus(ApproveStatus.PENDING)
            .build();
    }
}
