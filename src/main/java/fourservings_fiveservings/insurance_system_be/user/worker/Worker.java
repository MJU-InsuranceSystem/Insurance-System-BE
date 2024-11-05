package fourservings_fiveservings.insurance_system_be.user.worker;

import fourservings_fiveservings.insurance_system_be.user.Address;
import fourservings_fiveservings.insurance_system_be.user.User;
import fourservings_fiveservings.insurance_system_be.user.UserType;
import fourservings_fiveservings.insurance_system_be.user.auth.AuthGuideMessage;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@DiscriminatorValue("Worker")
public class Worker extends User {

    private Long hireYear;

    private Role role;

    @Builder
    private Worker(String loginId, String password, String email, String phoneNumber, Address address,
        String name,
        String birthDay, UserType userType, Long hireYear, Role role) {
        super(loginId, password, email, phoneNumber, address, name, birthDay, userType);
        this.hireYear = hireYear;
        this.role = role;
    }
}
