package fourservings_fiveservings.insurance_system_be.team.workerManagement.controller;


import fourservings_fiveservings.insurance_system_be.team.TeamController;
import fourservings_fiveservings.insurance_system_be.team.workerManagement.WorkerManagementTeam;
import fourservings_fiveservings.insurance_system_be.team.workerManagement.usecase.WorkerManagementUsecase;
import fourservings_fiveservings.insurance_system_be.team.workerManagement.view.WorkerManagementView;

public class WorkerManagementController implements TeamController {

    private final WorkerManagementTeam workerManagementTeam;
    private final WorkerManagementView workerManagementView;

    public WorkerManagementController(WorkerManagementTeam workerManagementTeam,
        WorkerManagementView workerManagementView) {
        this.workerManagementTeam = workerManagementTeam;
        this.workerManagementView = workerManagementView;
    }

    @Override
    public void process() {
        workerManagementView.intro("직원 관리 팀");
        int selectNumber = workerManagementView.selectUsecase(WorkerManagementUsecase.class);
        WorkerManagementUsecase usecase = WorkerManagementUsecase.findByNumber(selectNumber);
        executeUsecase(usecase);
    }

    private void executeUsecase(WorkerManagementUsecase usecase) {
        switch (usecase) {
            case ALL_WORKER_RETRIEVE -> {
                workerManagementView.showAllCustomerInfo(workerManagementTeam.retrieveWorkerInfo());
            }
            default -> throw new IllegalArgumentException("해당하는 usecase가 없습니다.");
        }
    }
}
