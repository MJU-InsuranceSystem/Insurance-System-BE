package fourservings_fiveservings.insurance_system_be.team.rewardSupport.claimInsurance;

import fourservings_fiveservings.insurance_system_be.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * @author USER
 * @version 1.0
 */
@Getter
@Setter
@Entity
public class ClaimInsurance extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String account;

    private String address;

    private String phoneNumber;

    private String residentNumber;

    private String supportingFile;




//    @Override
//    public String toString() {
//        return "\n" + "계좌 : " + account + "\n" +
//                "주소 : " + address + "\n" +
//                "전화번호 : " + phoneNumber + "\n" +
//                "주민번호 : " + residentNumber + "\n" +
//                "증빙 서류 : " + supportingFile + "\n" +
//                "--------------------------------------------" + "\n";
//    }

}
