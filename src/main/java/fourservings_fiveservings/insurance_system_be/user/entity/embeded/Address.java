package fourservings_fiveservings.insurance_system_be.user.entity.embeded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String country;
    private String city;
    private String zipCode;
}
