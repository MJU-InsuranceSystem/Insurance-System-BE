package fourservings_fiveservings.insurance_system_be.team.contract.car.controller.dto.request;

import fourservings_fiveservings.insurance_system_be.team.contract.car.entity.embaded.License;
import fourservings_fiveservings.insurance_system_be.team.contract.car.entity.type.LicenseType;
import java.time.LocalDate;

public record DriverLicenseRequestDto(
    String licenseNumber,
    String licenseType,
    LocalDate issueDate,
    LocalDate validityPeriod
) {

    public License toLicenseEntity() {
        return License.builder()
            .licenseNumber(this.licenseNumber)
            .licenseType(LicenseType.findByDescription(this.licenseType))
            .issueDate(this.issueDate)
            .validityPeriod(this.validityPeriod)
            .build();
    }

}
