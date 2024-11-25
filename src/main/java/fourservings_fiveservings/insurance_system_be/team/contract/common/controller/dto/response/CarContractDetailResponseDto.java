package fourservings_fiveservings.insurance_system_be.team.contract.common.controller.dto.response;

import fourservings_fiveservings.insurance_system_be.team.contract.car.entity.CarContract;
import fourservings_fiveservings.insurance_system_be.team.contract.car.entity.embaded.CarInformation;
import fourservings_fiveservings.insurance_system_be.team.contract.car.entity.embaded.License;
import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.embaded.ContractInformation;
import lombok.Builder;

@Builder
public record CarContractDetailResponseDto(
    Long contractId,
    ContractInformation contractInformation,
    License license,
    CarInformation carInformation
) {

    public static CarContractDetailResponseDto from(CarContract carContract) {
        return CarContractDetailResponseDto.builder()
            .contractId(carContract.getId())
            .contractInformation(carContract.getContractInformation())
            .license(carContract.getLicense())
            .carInformation(carContract.getCarInformation())
            .build();

    }
}
