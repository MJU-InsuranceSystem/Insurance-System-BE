package fourservings_fiveservings.insurance_system_be.team.contract.car.entity.embaded;

import fourservings_fiveservings.insurance_system_be.team.contract.car.entity.type.CarType;
import fourservings_fiveservings.insurance_system_be.team.contract.car.entity.type.OwnershipStatus;
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
public class CarInformation {

    private String carNumber;
    @Enumerated(EnumType.STRING)
    private CarType carType;
    private LocalDate modelYear;
    private LocalDate registrationDate;
    @Enumerated(EnumType.STRING)
    private OwnershipStatus ownershipStatus;
    private Integer accidentFreePeriod;
}
