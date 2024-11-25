package fourservings_fiveservings.insurance_system_be.team.contract.car.entity.type;

import com.fasterxml.jackson.annotation.JsonValue;
import fourservings_fiveservings.insurance_system_be.common.exception.ResourceNotFoundException;
import fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType;
import java.util.EnumSet;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

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
            .orElseThrow(() -> new ResourceNotFoundException(ErrorType.NO_EXIST_OWNER_TYPE));
    }

    @JsonValue
    public String getName() {
        return this.name;
    }
}
