package fourservings_fiveservings.insurance_system_be.user;

import jakarta.persistence.Embeddable;

@Embeddable
public record Address(
    String country,
    String city,
    String zipCode
) {
}
