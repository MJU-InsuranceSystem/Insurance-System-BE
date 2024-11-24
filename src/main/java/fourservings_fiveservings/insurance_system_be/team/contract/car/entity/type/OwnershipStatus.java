package fourservings_fiveservings.insurance_system_be.team.contract.car.entity.type;

import com.fasterxml.jackson.annotation.JsonValue;
import fourservings_fiveservings.insurance_system_be.common.exception.ResourceNotFoundException;
import fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.EnumSet;

@Getter
@RequiredArgsConstructor
public enum OwnershipStatus {
    OWN("소유"),
    LEASE("리스"),
    RENTAL("렌탈");

    private final String name;

    public static OwnershipStatus findByName(String name) {
        return EnumSet.allOf(OwnershipStatus.class).stream()
                .filter(ownershipStatus -> ownershipStatus.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException(ErrorType.RESOURCE_NOT_FOUND));
    }

    @JsonValue
    public String getName() {
        return this.name;
    }
}
