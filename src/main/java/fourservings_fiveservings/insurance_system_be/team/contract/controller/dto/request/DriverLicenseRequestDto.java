package fourservings_fiveservings.insurance_system_be.team.contract.controller.dto.request;

import fourservings_fiveservings.insurance_system_be.team.contract.entity.car.embaded.License;
import fourservings_fiveservings.insurance_system_be.team.contract.entity.car.type.LicenseType;
import java.time.LocalDate;

public record DriverLicenseRequestDto(
    String licenseNumber,
    LicenseType licenseType,
    LocalDate issueDate,
    LocalDate validityPeriod
) {

    public License toLicenseEntity() {
        return License.builder()
            .licenseNumber(this.licenseNumber())
            .licenseType(this.licenseType())
            .issueDate(this.issueDate())
            .validityPeriod(this.validityPeriod())
            .build();
    }
    
}
