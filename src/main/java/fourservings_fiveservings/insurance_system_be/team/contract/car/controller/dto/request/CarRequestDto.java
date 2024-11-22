package fourservings_fiveservings.insurance_system_be.team.contract.car.controller.dto.request;

import fourservings_fiveservings.insurance_system_be.team.contract.car.entity.embaded.CarInformation;
import fourservings_fiveservings.insurance_system_be.team.contract.car.entity.type.CarType;
import fourservings_fiveservings.insurance_system_be.team.contract.car.entity.type.OwnershipStatus;
import java.time.LocalDate;

public record CarRequestDto(
    String carNumber,
    CarType carType,
    LocalDate modelYear,
    LocalDate registrationDate,
    OwnershipStatus ownershipStatus,
    Integer accidentFreePeriod
) {

    public CarInformation toCarInformationEntity() {
        return CarInformation.builder()
            .carNumber(this.carNumber)
            .carType(this.carType)
            .modelYear(this.modelYear)
            .registrationDate(this.registrationDate)
            .ownershipStatus(ownershipStatus)
            .accidentFreePeriod(this.accidentFreePeriod)
            .build();
    }
}