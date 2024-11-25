package fourservings_fiveservings.insurance_system_be.team.contract.car.entity.type;

import fourservings_fiveservings.insurance_system_be.common.exception.ResourceNotFoundException;
import fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType;
import java.util.EnumSet;
import lombok.Getter;

@Getter
public enum CarType {
    PASSENGER_CAR("승용차"),
    SUV("SUV"),
    TRUCK("트럭"),
    VAN("밴"),
    RV("오토바이"),
    SPECIAL_VEHICLE("특수차량");

    private final String name;

    CarType(String name) {
        this.name = name;
    }

    public static CarType findByName(String name) {
        return EnumSet.allOf(CarType.class).stream()
            .filter(carType -> carType.getName().equals(name))
            .findFirst()
            .orElseThrow(() -> new ResourceNotFoundException(ErrorType.NO_EXIST_CAR_TYPE));

    }
}
