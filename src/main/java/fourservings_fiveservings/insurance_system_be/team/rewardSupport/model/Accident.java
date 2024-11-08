package fourservings_fiveservings.insurance_system_be.team.rewardSupport.model;


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


//    @Override
//    public String toString() {
//        return "Accident ID: " + id + "\n" +
//                "사고 내용: " + content + "\n" +
//                "고객 이름: " + customerName + "\n" +
//                "사고 정보: " + (claimInsurance != null ? claimInsurance.toString() : "null");
//    }

}