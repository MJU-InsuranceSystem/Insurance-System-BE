package fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.entity;


import fourservings_fiveservings.insurance_system_be.common.entity.BaseEntity;
import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.common.Contract;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.entity.enums.AccidentType;
import fourservings_fiveservings.insurance_system_be.user.entity.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Accident extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime accidentDate;

    private String description;

    private String location;

    private BigDecimal damageAmount;

    private String fileName;

    @Enumerated(EnumType.STRING)
    private AccidentType accidentType;

    @ManyToOne
    private Contract contract;

    @ManyToOne
    private Customer customer;

}
