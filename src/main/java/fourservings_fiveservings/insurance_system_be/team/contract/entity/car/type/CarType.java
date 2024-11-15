package fourservings_fiveservings.insurance_system_be.team.contract.entity.car.type;

import lombok.Getter;

@Getter
public enum CarType {
    PASSENGER_CAR("승용차"),
    SUV("SUV"),
    TRUCK("트럭"),
    VAN("밴"),
    RV("오토바이"),
    SPECIAL_VEHICLE("특수차량");
    private final String label;

    CarType(String label) {
        this.label = label;
    }
}
