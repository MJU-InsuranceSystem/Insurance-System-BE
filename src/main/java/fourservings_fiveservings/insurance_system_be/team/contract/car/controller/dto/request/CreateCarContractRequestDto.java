package fourservings_fiveservings.insurance_system_be.team.contract.car.controller.dto.request;

import fourservings_fiveservings.insurance_system_be.team.contract.CreateContractRequestDto;
import fourservings_fiveservings.insurance_system_be.team.contract.car.entity.CarContract;
import fourservings_fiveservings.insurance_system_be.team.contract.common.controller.dto.request.ContractRequestDto;
import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.common.ApproveStatus;
import fourservings_fiveservings.insurance_system_be.team.insurance.entity.Insurance;
import fourservings_fiveservings.insurance_system_be.user.entity.User;

public record CreateCarContractRequestDto(
    ContractRequestDto contractRequestDto,
    DriverLicenseRequestDto driverLicenseRequestDto,
    CarRequestDto carRequestDto

) implements CreateContractRequestDto {

    public CarContract createPendingContract(User appliedCustomer, Insurance insurance) {

        return CarContract.builder()
            .subscriber(appliedCustomer)
            .insurance(insurance)
            .approveStatus(ApproveStatus.PENDING)
            .contractInformation(contractRequestDto.toContractInformation())
            .license(driverLicenseRequestDto.toLicenseEntity())
            .carInformation(carRequestDto.toCarInformationEntity())
            .build();
    }
}
