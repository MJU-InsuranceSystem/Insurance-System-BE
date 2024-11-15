package fourservings_fiveservings.insurance_system_be.team.contract.controller.dto.request;

import fourservings_fiveservings.insurance_system_be.team.contract.entity.car.CarContract;
import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.Contract;
import fourservings_fiveservings.insurance_system_be.team.product.entity.Product;
import fourservings_fiveservings.insurance_system_be.team.product.insurance.ApproveStatus;
import fourservings_fiveservings.insurance_system_be.user.entity.User;

public record CarInsuranceJoinRequestDto(
    ContractRequestDto contractRequestDto,
    DriverLicenseRequestDto driverLicenseRequestDto,
    CarRequestDto carRequestDto

) {

    public Contract createPendingCarContract(User appliedCustomer, Product product) {

        return CarContract.builder()
            .subscriber(appliedCustomer)
            .product(product)
            .approveStatus(ApproveStatus.PENDING)
            .contractInformation(contractRequestDto.toContractInformation())
            .license(driverLicenseRequestDto.toLicenseEntity())
            .carInformation(carRequestDto.toCarInformationEntity())
            .build();
    }
}
