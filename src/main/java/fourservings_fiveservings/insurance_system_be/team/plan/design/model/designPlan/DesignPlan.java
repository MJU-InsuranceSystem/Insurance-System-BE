package fourservings_fiveservings.insurance_system_be.team.plan.design.model.designPlan;

import fourservings_fiveservings.insurance_system_be.team.plan.design.model.SaleTarget;
import fourservings_fiveservings.insurance_system_be.team.plan.design.model.proposal.Proposal;

/**
 * @author USER
 * @version 1.0
 */
public class DesignPlan {

    private String desingPlanTitle;
    private String content;
    private String Description;
    private String InsuranceName;
    private String Manager;
    private String insuranceType;
    private Proposal proposal;
    //    private String reward;
    private SaleTarget saleTarget;

    public DesignPlan() {

    }

    public void finalize() throws Throwable {

    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getInsuranceName() {
        return InsuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        InsuranceName = insuranceName;
    }

    public String getManager() {
        return Manager;
    }

    public void setManager(String manager) {
        Manager = manager;
    }

    public Proposal getProposal() {
        return proposal;
    }

    public void setProposal(Proposal proposal) {
        this.proposal = proposal;
    }

    public SaleTarget getSaleTarget() {
        return saleTarget;
    }

    public void setSaleTarget(SaleTarget saleTarget) {
        this.saleTarget = saleTarget;
    }

    public String getDesingPlanTitle() {
        return desingPlanTitle;
    }

    public void setDesingPlanTitle(String desingPlanTitle) {
        this.desingPlanTitle = desingPlanTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }
}