package fourservings_fiveservings.insurance_system_be.team.product.insurance.entity;


import fourservings_fiveservings.insurance_system_be.common.entity.BaseEntity;
import fourservings_fiveservings.insurance_system_be.team.product.insurance.InsuranceType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Insurance extends BaseEntity {

    @Id
    private Long insuranceId;

    public Insurance() {

    }

    private String insuranceName;
    private String description;
    private InsuranceType insuranceType;
    private String responsiblePerson;
    //    private Reward reward; 이거 보상으로 뺄껀지.
    private int coverage_amount;
    private String rightObligation;
    private String date;
    private String authorizedPerson;
    private String reason;

    @Override
    public String toString() {
        return "보험 ID: " + insuranceId + " 보험 이름: " + insuranceName + " 책임자: " + responsiblePerson;
//        +" 보상 최대액: " + reward.getMaxReward() + " 보험료 : " + reward.getMonthPaymentFee();
    }

    public void setInsuranceType(String order) {
        int selectNum = Integer.parseInt(order);
        this.insuranceType = InsuranceType.findByNumber(selectNum);
    }

    public Reward getReward() {
        return null;
    }

    public String toEntity() {
        return "todo";
//        return insuranceId + " " + insuranceName + " " + insuranceType.getDescription() + " " +
//            responsiblePerson + " " + rightObligation + " " + reward.getMaxReward() + " "
//            + reward.getInsuranceRate() + " " +
//            reward.getMonthPaymentFee() + " " + reward.getRestrictionRegulation();
    }

}
