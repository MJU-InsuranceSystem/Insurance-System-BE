package fourservings_fiveservings.insurance_system_be.team.workerManagement;


import fourservings_fiveservings.insurance_system_be.common.vo.RequestVO;
import fourservings_fiveservings.insurance_system_be.common.vo.ResponseVO;
import fourservings_fiveservings.insurance_system_be.team.TeamMethod;
import fourservings_fiveservings.insurance_system_be.user.worker.Worker;
import fourservings_fiveservings.insurance_system_be.user.worker.WorkerList;
import java.util.List;

/**
 * @author USER
 * @version 1.0
 */
public class WorkerManagementTeamMethod extends TeamMethod {

    private final WorkerList workerList = WorkerList.getInstance();

    @Override
    public ResponseVO manage(RequestVO request) {
        return null;
    }

    @Override
    public ResponseVO process(RequestVO request) {
        return null;
    }

    @Override
    public ResponseVO register(RequestVO request) {
        return null;
    }

    @Override
    public ResponseVO remove(RequestVO request) {
        return null;
    }

    @Override
    public ResponseVO retrieve(RequestVO request) {
        return null;
    }

    public List<Worker> retrieveWorkerInfo() {
        return workerList.getWorkerList();
    }

}