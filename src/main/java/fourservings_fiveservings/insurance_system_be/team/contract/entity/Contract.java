package fourservings_fiveservings.insurance_system_be.team.contract.entity;

import fourservings_fiveservings.insurance_system_be.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Contract extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String customerName;

    private String managerName;

    @Embedded
    private InsuranceApplication insuranceApplication;

    public void setInsurance(InsuranceApplication insuranceApplication) {
        this.insuranceApplication = insuranceApplication;
    }


//    @Override
//    public String toString() {
//        return "contract ID = " + id + "\n" +
//            "customer Name = " + customerName + '\n' +
//            "insurance ID = " + insuranceApplication.getInsuranceApplicationID() + '\n' +
//            "insurance Type = " + insuranceApplication.getInsurance().getInsuranceType() + '\n' +
//            "managerName = " + managerName;
//    }
}