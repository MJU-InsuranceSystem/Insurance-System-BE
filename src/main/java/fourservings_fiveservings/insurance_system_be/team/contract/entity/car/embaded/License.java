package fourservings_fiveservings.insurance_system_be.team.contract.entity.car.embaded;

import fourservings_fiveservings.insurance_system_be.team.contract.entity.car.type.LicenseType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class License {

    private String licenseNumber;
    @Enumerated(EnumType.STRING)
    private LicenseType licenseType;
    private LocalDate issueDate;
    private LocalDate validityPeriod;
}
