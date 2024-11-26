package fourservings_fiveservings.insurance_system_be.team.contract.car.controller.dto.request;

import fourservings_fiveservings.insurance_system_be.team.contract.car.entity.CarContract;
import fourservings_fiveservings.insurance_system_be.team.contract.common.controller.dto.request.ContractRequestDto;
import fourservings_fiveservings.insurance_system_be.team.contract.common.controller.dto.request.CreateContractRequestDto;
import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.type.ApproveStatus;
import fourservings_fiveservings.insurance_system_be.team.insurance.entity.Insurance;
import fourservings_fiveservings.insurance_system_be.user.entity.Customer;

public record CreateCarContractRequestDto(
    ContractRequestDto contractRequestDto,
    DriverLicenseRequestDto driverLicenseRequestDto,
    CarRequestDto carRequestDto

) implements CreateContractRequestDto {

    public CarContract createPendingContract(Customer appliedCustomer, Insurance insurance) {

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
