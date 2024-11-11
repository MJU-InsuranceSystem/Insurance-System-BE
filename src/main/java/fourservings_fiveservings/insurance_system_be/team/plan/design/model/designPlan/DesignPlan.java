package fourservings_fiveservings.insurance_system_be.team.plan.design.model.designPlan;

import fourservings_fiveservings.insurance_system_be.common.entity.BaseEntity;
import fourservings_fiveservings.insurance_system_be.team.plan.design.model.SaleTarget;
import fourservings_fiveservings.insurance_system_be.team.plan.design.model.proposal.Proposal;
import fourservings_fiveservings.insurance_system_be.user.entity.Worker;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

/**
 * @author USER
 * @version 1.0
 */
@Entity
public class DesignPlan extends BaseEntity {

    @Id
    private Long id;

    private String designPlanTitle;
    private String Description;
    private String InsuranceName;
    @ManyToOne
    private Worker worker;
    private String insuranceType;

    @OneToOne
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
        return null;
    }

    public void setManager(String manager) {
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

    public String getDesignPlanTitle() {
        return designPlanTitle;
    }

    public void setDesignPlanTitle(String desingPlanTitle) {
        this.designPlanTitle = desingPlanTitle;
    }

    public String getContent() {
        return null;
    }

    public void setContent(String content) {
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }
}
