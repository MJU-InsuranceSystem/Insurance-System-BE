package fourservings_fiveservings.insurance_system_be.team.plan.design.controller;

import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.ALL;
import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.ENTITY_KIND;
import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.ENTITY_LIST;

import fourservings_fiveservings.insurance_system_be.common.dto.RequestVO;
import fourservings_fiveservings.insurance_system_be.common.dto.ResponseVO;
import fourservings_fiveservings.insurance_system_be.team.Team;
import fourservings_fiveservings.insurance_system_be.team.TeamController;
import fourservings_fiveservings.insurance_system_be.team.plan.design.model.designPlan.DesignConstant;
import fourservings_fiveservings.insurance_system_be.team.plan.design.model.proposal.ProposalConstant;
import fourservings_fiveservings.insurance_system_be.team.plan.design.usecase.DesignUseCase;
import fourservings_fiveservings.insurance_system_be.team.plan.design.view.InsurancePlanView;
import fourservings_fiveservings.insurance_system_be.team.plan.inspection.InsuranceInspectionView;
import java.util.Objects;

public class InsurancePlanController implements TeamController {

    private final InsurancePlanView insurancePlanView;
    private final InsuranceInspectionView insuranceInspectionView;
    private final Team insurancePlanTeam;
    private final Team insuranceInspectionTeam;

    public InsurancePlanController(InsurancePlanView insurancePlanView,
        InsuranceInspectionView insuranceInspectionView, Team insurancePlanTeam,
        Team insuranceInspectionTeam) {
        this.insurancePlanView = insurancePlanView;
        this.insuranceInspectionView = insuranceInspectionView;
        this.insurancePlanTeam = insurancePlanTeam;
        this.insuranceInspectionTeam = insuranceInspectionTeam;
    }


    @Override
    public void process() {
        this.insurancePlanView.intro(ProposalConstant.DESIGN_TEAM_NAME);
        int selectInt = this.insurancePlanView.selectUsecase(DesignUseCase.class);
        DesignUseCase useCase = DesignUseCase.findByNumber(selectInt);
        startProcess(useCase);
    }

    private void startProcess(DesignUseCase useCase) {
        switch (useCase) {
            case ASK_INSURANCE_AUTHORIZATION -> {
                RequestVO requestVO = insurancePlanView.requestAuthorization();
                ResponseVO responseVO = insurancePlanTeam.retrieve(requestVO);
                requestVO = insurancePlanView.requestAuthorization(responseVO);
                responseVO = insurancePlanTeam.retrieve(requestVO);

                requestVO = insuranceInspectionView.authorizationInsurance(responseVO);
                responseVO = insurancePlanTeam.process(requestVO);
                insurancePlanView.showAuthrizationResult(responseVO);
            }
            case PLAN_INSURANCE -> {
                RequestVO requestVO = insurancePlanView.createProposal();
                ResponseVO responseVO = insurancePlanTeam.register(requestVO);
                insurancePlanView.completeCreateProposal(responseVO);
            }
            case DESIGN_INSURANCE -> {
                RequestVO requestVO = new RequestVO();
                ResponseVO responseVO;
                requestVO.add(ENTITY_LIST, ALL);
                requestVO.add(ENTITY_KIND, ProposalConstant.PROPOSAL);

                requestVO = insurancePlanView.selectProposal(insurancePlanTeam.retrieve(requestVO));
                responseVO = insurancePlanTeam.retrieve(requestVO);
                requestVO = insurancePlanView.createDesign(responseVO);
                RequestVO requestInsuranceDto = insurancePlanView.createInsurance();

                insurancePlanTeam.register(requestInsuranceDto);
                responseVO = insurancePlanTeam.register(requestVO);
                insurancePlanView.completeCreateDesignPlan(responseVO);
            }
            case MANAGE_INSURANCE -> {
                RequestVO requestVO = insurancePlanView.requestInsurances();
                if (Objects.equals(requestVO.get(DesignConstant.READ_INSURANCE_RESULT), "Y")) {
                    ResponseVO responseVO = insurancePlanTeam.retrieve(requestVO);
                    insurancePlanView.showAllInsurance(responseVO);
                    return;
                }
                insurancePlanView.denyShowInsurances();
            }
            default -> throw new IllegalArgumentException("해당 유스케이스 번호는 존재하지 않습니다.");
        }
    }
}
