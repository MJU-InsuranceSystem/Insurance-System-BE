package fourservings_fiveservings.insurance_system_be.team.contract.car.controller.dto.request;

import fourservings_fiveservings.insurance_system_be.team.contract.car.entity.embaded.CarInformation;
import fourservings_fiveservings.insurance_system_be.team.contract.car.entity.type.CarType;
import fourservings_fiveservings.insurance_system_be.team.contract.car.entity.type.OwnershipStatus;
import java.time.LocalDate;

public record CarRequestDto(
    String carNumber,
    String carType,
    LocalDate modelYear,
    LocalDate registrationDate,
    String ownershipStatus,
    Integer accidentFreePeriod
) {

    public CarInformation toCarInformationEntity() {
        return CarInformation.builder()
            .carNumber(this.carNumber)
            .carType(CarType.findByName(this.carType))
            .modelYear(this.modelYear)
            .registrationDate(this.registrationDate)
            .ownershipStatus(OwnershipStatus.findByName(ownershipStatus))
            .accidentFreePeriod(this.accidentFreePeriod)
            .build();
    }
}