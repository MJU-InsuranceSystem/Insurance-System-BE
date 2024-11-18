package fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.entity;


import fourservings_fiveservings.insurance_system_be.common.entity.BaseEntity;
import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.Contract;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author USER
 * @version 1.0
 */
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Accident extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime accidentDate;

    private String description;

    private String location;

    private int damageAmount;

    @ManyToOne
    private Contract contract;

}
