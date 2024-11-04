package fourservings_fiveservings.insurance_system_be.team.rewardSupport.controller;


import fourservings_fiveservings.insurance_system_be.common.dto.RequestVO;
import fourservings_fiveservings.insurance_system_be.common.dto.ResponseVO;
import fourservings_fiveservings.insurance_system_be.insurance.apply.InsuranceChargeCustomerApplyList;
import fourservings_fiveservings.insurance_system_be.team.TeamController;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.RewardSupportTeam;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.usecase.RewardSupportUseCase;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.view.RewardSupportView;

public class RewardSupportController implements TeamController {

    private final RewardSupportView rewardSupportView;
    private final RewardSupportTeam rewardSupportTeam;


    public RewardSupportController(RewardSupportView rewardSupportView,
        RewardSupportTeam rewardSupportTeam,
        InsuranceChargeCustomerApplyList insuranceChargeCustomerApplyList) {
        this.rewardSupportView = rewardSupportView;
        this.rewardSupportTeam = rewardSupportTeam;

    }

    @Override
    public void process() {
        this.rewardSupportView.intro("보상 지원팀");
        int selectInt = this.rewardSupportView.selectUsecase(RewardSupportUseCase.class);
        RewardSupportUseCase usecase = RewardSupportUseCase.findByNumber(selectInt);
        executeUsecase(usecase);
    }

    private void executeUsecase(RewardSupportUseCase usecase) {
        switch (usecase) {
            case JUDGE_FAULT -> {
                RequestVO tempRequest = new RequestVO();
                ResponseVO tempResponseVO = rewardSupportTeam.retrieve(tempRequest);
                RequestVO requestVO = rewardSupportView.judgeFault(tempResponseVO);
                ResponseVO responseVO = rewardSupportTeam.process(requestVO);
                rewardSupportView.completeJudgeFault(responseVO);
            }
            case PAY_INSURANCE -> {
                RequestVO tempRequest = new RequestVO();
                ResponseVO tempResponseVO = rewardSupportTeam.register(tempRequest);
                RequestVO requestVO = rewardSupportView.payInsurance(tempResponseVO);
                ResponseVO responseVO = rewardSupportTeam.retrieve(requestVO);
                rewardSupportView.completePayInsurance(responseVO);
            }
            case MANAGE_LAWSUIT -> {
                RequestVO requestVO = rewardSupportView.manageLawsuit();

            }
            case CHECK_NOT_PAID_CUSTOMER -> {
                ResponseVO responseVO = rewardSupportTeam.getNotPaidCustomer();
                rewardSupportView.showNotPaidCustomer(responseVO);
            }
            default -> throw new IllegalArgumentException("해당하는 usecase가 없습니다.");
        }
    }
}

