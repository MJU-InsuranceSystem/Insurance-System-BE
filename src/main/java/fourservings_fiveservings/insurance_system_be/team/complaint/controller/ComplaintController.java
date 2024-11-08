package fourservings_fiveservings.insurance_system_be.team.complaint.controller;


import fourservings_fiveservings.insurance_system_be.common.vo.RequestVO;
import fourservings_fiveservings.insurance_system_be.team.TeamController;
import fourservings_fiveservings.insurance_system_be.team.complaint.ComplaintManagementTeamMethod;
import fourservings_fiveservings.insurance_system_be.team.complaint.usecase.ComplaintUseCase;
import fourservings_fiveservings.insurance_system_be.team.complaint.view.ComplaintView;

public class ComplaintController implements TeamController {

    private final ComplaintView complaintView;
    private final ComplaintManagementTeamMethod complaintManagementTeam;

    public ComplaintController(ComplaintView complaintView,
        ComplaintManagementTeamMethod complaintManagementTeam) {
        this.complaintView = complaintView;
        this.complaintManagementTeam = complaintManagementTeam;
    }

    @Override
    public void process() {
        complaintView.intro("민원 관리");
        int selectNumber = complaintView.selectUsecase(ComplaintUseCase.class);
        ComplaintUseCase useCase = ComplaintUseCase.findByNumber(selectNumber);
        RequestVO requestVO = showUseCaseRequireInfo(useCase);
        complaintManagementTeam.register(requestVO);
    }

    private RequestVO showUseCaseRequireInfo(ComplaintUseCase useCase) {
        switch (useCase) {
            case REGISTER_COMPLAINT -> {
                return complaintView.registerComplaint();
            }
            case REQUEST_PROCESSING_STATUS -> {
                return null; // 아직 고민 중
            }
            case EVALUATE_COMPLAINT -> {
                return complaintView.evaluateComplaint();
            }
            default -> throw new IllegalArgumentException("해당 유스케이스 번호는 존재하지 않습니다.");
        }
    }
}
