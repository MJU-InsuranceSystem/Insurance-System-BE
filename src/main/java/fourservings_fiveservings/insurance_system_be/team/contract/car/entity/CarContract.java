package fourservings_fiveservings.insurance_system_be.team.contract.car.entity;


import fourservings_fiveservings.insurance_system_be.team.contract.car.entity.embaded.CarInformation;
import fourservings_fiveservings.insurance_system_be.team.contract.car.entity.embaded.License;
import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.common.Contract;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CarContract extends Contract {

    @Embedded
    private License license;

    @Embedded
    private CarInformation carInformation;
}
