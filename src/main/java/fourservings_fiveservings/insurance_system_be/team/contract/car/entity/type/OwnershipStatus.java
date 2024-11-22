package fourservings_fiveservings.insurance_system_be.team.contract.car.entity.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OwnershipStatus {
    OWN("소유"),
    LEASE("리스"),
    RENTAL("렌탈");
    private final String label;

}
