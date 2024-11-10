package fourservings_fiveservings.insurance_system_be.team.rewardSupport.entity;


import fourservings_fiveservings.insurance_system_be.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author USER
 * @version 1.0
 */
@Getter
@Setter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Accident extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;

    private String customerName;

    // ----------------------

    private LocalDateTime accidentDate;

    private String description;

    private String location;

    private int damageAmount;

    public Accident() {

    }
}