package fourservings_fiveservings.insurance_system_be.user.worker;

import fourservings_fiveservings.insurance_system_be.user.User;
import fourservings_fiveservings.insurance_system_be.user.UserType;
import fourservings_fiveservings.insurance_system_be.user.auth.AuthGuideMessage;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@DiscriminatorValue("Worker")
@SuperBuilder
public class Worker extends User {

    private Long hireYear;

    private Role role;
}
