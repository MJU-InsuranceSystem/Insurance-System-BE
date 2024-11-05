package fourservings_fiveservings.insurance_system_be.team;

import fourservings_fiveservings.insurance_system_be.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Team extends BaseEntity {

    @Id
    private Long teamId;
    private String teamName;
    private String type;

}
