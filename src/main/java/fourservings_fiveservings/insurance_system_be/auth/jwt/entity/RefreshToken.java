package fourservings_fiveservings.insurance_system_be.auth.jwt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
@AllArgsConstructor
public class RefreshToken {

    @Id
    private String memberEmail;

    private String refreshToken;

}
