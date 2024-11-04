package fourservings_fiveservings.insurance_system_be.team.plan.design;


import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.ALL;
import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.ENTITY;
import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.ENTITY_KIND;
import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.ENTITY_LIST;
import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.INSURANCE;
import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.INSURANCE_NAME;
import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.ONE;
import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.RESPONSIBLE_PERSON;
import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.RESTRICTION_REGULATION;
import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.SUBSCRIBER_RIGHTS_AND_OBLIGATION;
import static fourservings_fiveservings.insurance_system_be.insurance.reward.RewardConstant.INSURANCE_RATE;
import static fourservings_fiveservings.insurance_system_be.insurance.reward.RewardConstant.MAX_REWARD;
import static fourservings_fiveservings.insurance_system_be.insurance.reward.RewardConstant.MONTH_PAYMENT_FEE;
import static fourservings_fiveservings.insurance_system_be.user.customer.CustomerView.INSURANCE_NUMBER;

import fourservings_fiveservings.insurance_system_be.common.dto.RequestVO;
import fourservings_fiveservings.insurance_system_be.common.dto.ResponseVO;
import fourservings_fiveservings.insurance_system_be.insurance.Insurance;
import fourservings_fiveservings.insurance_system_be.insurance.InsuranceList;
import fourservings_fiveservings.insurance_system_be.insurance.reward.Reward;
import fourservings_fiveservings.insurance_system_be.team.Team;
import fourservings_fiveservings.insurance_system_be.team.plan.Status;
import fourservings_fiveservings.insurance_system_be.team.plan.design.model.designPlan.DesignConstant;
import fourservings_fiveservings.insurance_system_be.team.plan.design.model.designPlan.DesignPlan;
import fourservings_fiveservings.insurance_system_be.team.plan.design.model.designPlan.DesignPlanList;
import fourservings_fiveservings.insurance_system_be.team.plan.design.model.proposal.Proposal;
import fourservings_fiveservings.insurance_system_be.team.plan.design.model.proposal.Proposal.ProposalBuilder;
import fourservings_fiveservings.insurance_system_be.team.plan.design.model.proposal.ProposalConstant;
import fourservings_fiveservings.insurance_system_be.team.plan.design.model.proposal.ProposalList;
import java.util.Objects;

/**
 * @author USER
 * @version 1.0
 */
public class InsurancePlanTeam extends Team {

    private final DesignPlanList designPlanList;
    private final ProposalList proposalList;
    private final InsuranceList insuranceList;
    private final InsuranceList authrizationInsuranceList;


    public InsurancePlanTeam(DesignPlanList designPlanList, ProposalList proposalList,
        InsuranceList insuranceList, InsuranceList authrizationInsuranceList) {
        this.designPlanList = designPlanList;
        this.proposalList = proposalList;
        this.insuranceList = insuranceList;
        this.authrizationInsuranceList = authrizationInsuranceList;
    }

    @Override
    public ResponseVO manage(RequestVO request) {
        return null;
    }

    @Override
    public ResponseVO process(RequestVO request) {
        ResponseVO responseVO = new ResponseVO();
        switch (request.get(ProposalConstant.KIND)) {
            case "인가" -> {
                if (request.get("인가응답").equalsIgnoreCase("y")) {
                    Insurance insurance = insuranceList.findById(
                        Integer.parseInt(request.get(INSURANCE_NUMBER)));
                    insurance.setDate(request.get("날짜"));
                    insurance.setAuthorizedPerson(request.get("책임자이름"));
                    insurance.setReason(request.get("reason"));
//                    authrizationInsuranceList.add(insurance);
                    if (!Objects.isNull(authrizationInsuranceList.findById(
                        Integer.parseInt(request.get(INSURANCE_NUMBER))))) {
                        responseVO.add(Status.getKey(), Status.SUCCESS.getStatus());
                        return responseVO;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public ResponseVO register(RequestVO request) {
        ResponseVO responseVO = new ResponseVO();
        switch (request.get(ProposalConstant.KIND)) {
            case ProposalConstant.PROPOSAL -> {
                Proposal proposal = new ProposalBuilder().proposalId(proposalList.getSize())
                    .title(request.get(ProposalConstant.PROPOSAL_TITLE))
                    .productOverview(request.get(ProposalConstant.PRODUCT_OVERVIEW))
                    .marketResearch(request.get(ProposalConstant.MARKET_RESEARCH))
                    .insurancePayment(request.get(ProposalConstant.Insurance_Payment))
                    .saleStrategy(request.get(ProposalConstant.SALE_STRATEGY))
                    .saleTarget(request.get(
                        ProposalConstant.SALE_TARGET))
                    .reward(request.get(ProposalConstant.REWARD)).build();

                proposalList.add(proposal);
                responseVO.add(Status.getKey(), Status.SUCCESS.getStatus());
                return responseVO;
            }
            case INSURANCE -> {
                Insurance insurance = new Insurance();
                insurance.setInsuranceId(Integer.toString(this.insuranceList.findAll().size()));
                insurance.setInsuranceType(request.get(ProposalConstant.INSURANCE_KIND));
                insurance.setInsuranceName(request.get(INSURANCE_NAME));
                insurance.setResponsiblePerson(request.get(RESPONSIBLE_PERSON));
                insurance.setReightObligation(request.get(SUBSCRIBER_RIGHTS_AND_OBLIGATION));

                Reward reward = insurance.getReward();
                reward.setRewardId(Integer.parseInt(insurance.getInsuranceId()));
                reward.setMaxReward(Integer.parseInt(request.get(MAX_REWARD)));
                reward.setMonthPaymentFee(Integer.parseInt(request.get(MONTH_PAYMENT_FEE)));
                reward.setInsuranceRate(Integer.parseInt(request.get(INSURANCE_RATE)));
                reward.setRestrictionRegulation(request.get(RESTRICTION_REGULATION));

                this.insuranceList.add(insurance);

                responseVO.add(Status.getKey(), Status.SUCCESS.getStatus());
                return responseVO;
            }
            case DesignConstant.DESIGNPLAN -> {
                DesignPlan designPlan = new DesignPlan();
                designPlan.setProposal(
                    proposalList.findById(Integer.parseInt(request.get("기획서번호"))));
                designPlan.setDesingPlanTitle(request.get(DesignConstant.DESIGN_TITLE));
                designPlan.setContent(request.get(DesignConstant.DESIGN_CONTENT));
                designPlan.setManager(request.get(DesignConstant.DESIGN_MANAGER));
                designPlanList.add(designPlan);
                responseVO.add(Status.getKey(), Status.SUCCESS.getStatus());
                return responseVO;
            }
            default -> {
                throw new IllegalArgumentException("해당 유스케이스 번호는 존재하지 않습니다.");
            }
        }

    }

    @Override
    public ResponseVO remove(RequestVO request) {
        return null;
    }

    @Override
    public ResponseVO retrieve(RequestVO request) {
        ResponseVO responseVO = new ResponseVO();
        switch (request.get(ENTITY_LIST)) {
            case ALL -> {
                switch (request.get(ENTITY_KIND)) {
                    case INSURANCE -> {
                        for (Insurance insurance : insuranceList.findAll()) {
                            responseVO.add(insurance.getInsuranceId(), insurance.toString());
                        }
                    }
                    case ProposalConstant.PROPOSAL -> {
                        for (Proposal proposal : proposalList.getList()) {
                            responseVO.add(Integer.toString(proposal.getProposalId()),
                                proposal.toString());
                        }
                    }
                }


            }
            case ONE -> {
                switch (request.get(ENTITY_KIND)) {
                    case INSURANCE -> {
                        Insurance insurance = insuranceList.findById(
                            Integer.parseInt(request.get("선택번호")));
                        responseVO.add(INSURANCE_NUMBER, insurance.getInsuranceId());
                        responseVO.add(INSURANCE_NAME, insurance.getInsuranceName());
                        responseVO.add(ProposalConstant.INSURANCE_KIND,
                            insurance.getInsuranceType().getDescription());
                        responseVO.add(RESPONSIBLE_PERSON, insurance.getResponsiblePerson());
                        Reward reward = insurance.getReward();
                        responseVO.add(MAX_REWARD, Integer.toString(reward.getMaxReward()));
                        responseVO.add(MONTH_PAYMENT_FEE,
                            Integer.toString(reward.getMonthPaymentFee()));
                        responseVO.add(INSURANCE_RATE,
                            Integer.toString(reward.getInsuranceRate()));
                        responseVO.add(RESTRICTION_REGULATION, reward.getRestrictionRegulation());
                        responseVO.add(ENTITY, insurance.toEntity());
                    }
                    case ProposalConstant.PROPOSAL -> {
                        Proposal proposal = proposalList.findById(
                            Integer.parseInt(request.get("선택번호")));
                        responseVO.add(ENTITY, proposal.toEntity());
                    }
                    case DesignConstant.DESIGNPLAN -> {

                    }
                }
            }
        }
        return responseVO;

    }
}