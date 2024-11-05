package fourservings_fiveservings.insurance_system_be.team.plan.design.model.proposal;

import fourservings_fiveservings.insurance_system_be.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * @author USER
 * @version 1.0
 */
@Entity
public class Proposal extends BaseEntity {

    @Id
    private Long proposalId;
    private String title;
    private String productOverview;
    private String marketResearch;
    private String insurancePayment;
    private String saleStrategy;
    private String saleTarget;
    private String reward;

    public Proposal() {

    }

    private Proposal(ProposalBuilder proposalBuilder) {
        this.proposalId = proposalBuilder.proposalId;
        this.title = proposalBuilder.title;
        this.productOverview = proposalBuilder.productOverview;
        this.marketResearch = proposalBuilder.marketResearch;
        this.insurancePayment = proposalBuilder.insurancePayment;
        this.saleStrategy = proposalBuilder.saleStrategy;
        this.saleTarget = proposalBuilder.saleTarget;
        this.reward = proposalBuilder.reward;
    }


    public static class ProposalBuilder {

        private Long proposalId;
        private String title;
        private String productOverview;
        private String marketResearch;
        private String insurancePayment;
        private String saleStrategy;
        private String saleTarget;
        private String reward;

        public ProposalBuilder proposalId(long proposalId) {
            this.proposalId = proposalId;
            return this;
        }

        public ProposalBuilder title(String title) {
            this.title = title;
            return this;
        }

        public ProposalBuilder productOverview(String productOverview) {
            this.productOverview = productOverview;
            return this;
        }

        public ProposalBuilder marketResearch(String marketResearch) {
            this.marketResearch = marketResearch;
            return this;
        }

        public ProposalBuilder insurancePayment(String insurancePayment) {
            this.insurancePayment = insurancePayment;
            return this;
        }

        public ProposalBuilder saleStrategy(String saleStrategy) {
            this.saleStrategy = saleStrategy;
            return this;
        }

        public ProposalBuilder saleTarget(String saleTarget) {
            this.saleTarget = saleTarget;
            return this;
        }

        public ProposalBuilder reward(String reward) {
            this.reward = reward;
            return this;
        }

        public Proposal build() {
            return new Proposal(this);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        // Cleanup logic
    }

    public int getProposalId() {
        return 1;
    }

    public String getTitle() {
        return title;
    }

    public String getProductOverview() {
        return productOverview;
    }

    public String getMarketResearch() {
        return marketResearch;
    }

    public String getInsurancePayment() {
        return insurancePayment;
    }

    public String getSaleStrategy() {
        return saleStrategy;
    }

    public String getSaleTarget() {
        return saleTarget;
    }

    public String getReward() {
        return reward;
    }

    public void setProposalId(long proposalId) {
        this.proposalId = proposalId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setProductOverview(String productOverview) {
        this.productOverview = productOverview;
    }

    public void setMarketResearch(String marketResearch) {
        this.marketResearch = marketResearch;
    }

    public void setInsurancePayment(String insurancePayment) {
        this.insurancePayment = insurancePayment;
    }

    public void setSaleStrategy(String saleStrategy) {
        this.saleStrategy = saleStrategy;
    }

    public void setSaleTarget(String saleTarget) {
        this.saleTarget = saleTarget;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    @Override
    public String toString() {
        return "기획서 제목: " + title + "/ 개요: "
            + productOverview + "/ 시장 조사: " + marketResearch + "/ 보험료: "
            + insurancePayment + "/ 판매 전략: " + saleStrategy + "/ 예상 판매 대상: " + saleTarget
            + "/ 보상: " + reward;
    }

    public String toEntity() {
        return proposalId + " " + title + " " + productOverview + " " + marketResearch + " "
            + insurancePayment + " " + saleStrategy + " " + saleTarget + " " + reward;
    }
}
