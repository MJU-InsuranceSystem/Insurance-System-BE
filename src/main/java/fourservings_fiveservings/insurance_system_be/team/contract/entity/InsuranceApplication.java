package fourservings_fiveservings.insurance_system_be.team.contract.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author USER
 * @version 1.0
 */
@Data
@Embeddable
@NoArgsConstructor()
@AllArgsConstructor()
public class InsuranceApplication {

    private int insuranceId;

    private String subscriberName;

    private String personalInfo;

    private String familyHistory;

    private String requestInsurance;

//    private Insurance insurance;
}
