package fourservings_fiveservings.insurance_system_be.insurance;


import fourservings_fiveservings.insurance_system_be.insurance.reward.Reward;

public class Insurance {

    public Insurance() {
        this.reward = new Reward();
    }

    private String insuranceId;
    private String insuranceName;
    private InsuranceType insuranceType;
    private String responsiblePerson;
    private Reward reward;
    private String reightObligation;
    private String date;
    private String authorizedPerson;
    private String reason;

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }


    public void setReightObligation(String reightObligation) {
        this.reightObligation = reightObligation;
    }

    public void setInsuranceId(String id) {
        this.insuranceId = id;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public InsuranceType getInsuranceType() {
        return insuranceType;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthorizedPerson() {
        return authorizedPerson;
    }

    public void setAuthorizedPerson(String authorizedPerson) {
        this.authorizedPerson = authorizedPerson;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "보험 ID: " + insuranceId + " 보험 이름: " + insuranceName + " 책임자: " + responsiblePerson
            + " 보상 최대액: " + reward.getMaxReward() + " 보험료 : " + reward.getMonthPaymentFee();
    }

    public void setInsuranceType(String order) {
        int selectNum = Integer.parseInt(order);
        this.insuranceType = InsuranceType.findByNumber(selectNum);
    }

    public String toEntity() {
        return insuranceId + " " + insuranceName + " " + insuranceType.getDescription() + " " +
            responsiblePerson + " " + reightObligation + " " + reward.getMaxReward() + " "
            + reward.getInsuranceRate() + " " +
            reward.getMonthPaymentFee() + " " + reward.getRestrictionRegulation();
    }
}
