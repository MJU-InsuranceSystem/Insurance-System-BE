package fourservings_fiveservings.insurance_system_be.user.worker;


import fourservings_fiveservings.insurance_system_be.common.view.SystemView;
import fourservings_fiveservings.insurance_system_be.team.Department;

public class WorkerSystem {

    private SystemView systemView;

    public WorkerSystem(SystemView systemView) {
        this.systemView = systemView;
    }

    public void process() {
        while (true) {
            int selectTeamNumber = systemView.selectTeam();
            if (selectTeamNumber == 0) {
                break;
            }
            Department.findTeamByNumber(selectTeamNumber).getTeamController().process();
        }
    }
}
