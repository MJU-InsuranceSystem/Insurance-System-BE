package fourservings_fiveservings.insurance_system_be.team.contract.entity.car;


import fourservings_fiveservings.insurance_system_be.team.contract.entity.car.embaded.CarInformation;
import fourservings_fiveservings.insurance_system_be.team.contract.entity.car.embaded.License;
import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.Contract;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CarContract extends Contract {

    @Embedded
    private License license;

    @Embedded
    private CarInformation carInformation;
}
