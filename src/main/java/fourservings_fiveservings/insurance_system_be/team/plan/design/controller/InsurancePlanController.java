package fourservings_fiveservings.insurance_system_be.team.plan.design.controller;

//    public InsurancePlanController(InsurancePlanView insurancePlanView,
//        InsuranceInspectionView insuranceInspectionView, TeamMethod insurancePlanTeamMethod,
//        TeamMethod insuranceInspectionTeamMethod) {
//        this.insurancePlanView = insurancePlanView;
//        this.insuranceInspectionView = insuranceInspectionView;
//        this.insurancePlanTeamMethod = insurancePlanTeamMethod;
//        this.insuranceInspectionTeamMethod = insuranceInspectionTeamMethod;
//    }

public class InsurancePlanController {

//    private final InsurancePlanView insurancePlanView;
//    private final InsuranceInspectionView insuranceInspectionView;
//    private final TeamMethod insurancePlanTeamMethod;
//    private final TeamMethod insuranceInspectionTeamMethod;
//
//    public InsurancePlanController(InsurancePlanView insurancePlanView,
//        InsuranceInspectionView insuranceInspectionView, TeamMethod insurancePlanTeamMethod,
//        TeamMethod insuranceInspectionTeamMethod) {
//        this.insurancePlanView = insurancePlanView;
//        this.insuranceInspectionView = insuranceInspectionView;
//        this.insurancePlanTeamMethod = insurancePlanTeamMethod;
//        this.insuranceInspectionTeamMethod = insuranceInspectionTeamMethod;
//    }
//
//
//    @Override
//    public void process() {
//        this.insurancePlanView.intro(ProposalConstant.DESIGN_TEAM_NAME);
//        int selectInt = this.insurancePlanView.selectUsecase(DesignUseCase.class);
//        DesignUseCase useCase = DesignUseCase.findByNumber(selectInt);
//        startProcess(useCase);
//    }
//
//    private void startProcess(DesignUseCase useCase) {
//        switch (useCase) {
//            case ASK_INSURANCE_AUTHORIZATION -> {
//                RequestVO requestVO = insurancePlanView.requestAuthorization();
//                ResponseVO responseVO = insurancePlanTeamMethod.retrieve(requestVO);
//                requestVO = insurancePlanView.requestAuthorization(responseVO);
//                responseVO = insurancePlanTeamMethod.retrieve(requestVO);
//
//                requestVO = insuranceInspectionView.authorizationInsurance(responseVO);
//                responseVO = insurancePlanTeamMethod.process(requestVO);
//                insurancePlanView.showAuthrizationResult(responseVO);
//            }
//            case PLAN_INSURANCE -> {
//                RequestVO requestVO = insurancePlanView.createProposal();
//                ResponseVO responseVO = insurancePlanTeamMethod.register(requestVO);
//                insurancePlanView.completeCreateProposal(responseVO);
//            }
//            case DESIGN_INSURANCE -> {
//                RequestVO requestVO = new RequestVO();
//                ResponseVO responseVO;
//                requestVO.add(ENTITY_LIST, ALL);
//                requestVO.add(ENTITY_KIND, ProposalConstant.PROPOSAL);
//
//                requestVO = insurancePlanView.selectProposal(
//                    insurancePlanTeamMethod.retrieve(requestVO));
//                responseVO = insurancePlanTeamMethod.retrieve(requestVO);
//                requestVO = insurancePlanView.createDesign(responseVO);
//                RequestVO requestInsuranceDto = insurancePlanView.createInsurance();
//
//                insurancePlanTeamMethod.register(requestInsuranceDto);
//                responseVO = insurancePlanTeamMethod.register(requestVO);
//                insurancePlanView.completeCreateDesignPlan(responseVO);
//            }
//            case MANAGE_INSURANCE -> {
//                RequestVO requestVO = insurancePlanView.requestInsurances();
//                if (Objects.equals(requestVO.get(DesignConstant.READ_INSURANCE_RESULT), "Y")) {
//                    ResponseVO responseVO = insurancePlanTeamMethod.retrieve(requestVO);
//                    insurancePlanView.showAllInsurance(responseVO);
//                    return;
//                }
//                insurancePlanView.denyShowInsurances();
//            }
//            default -> throw new IllegalArgumentException("해당 유스케이스 번호는 존재하지 않습니다.");
//        }
//    }
}
