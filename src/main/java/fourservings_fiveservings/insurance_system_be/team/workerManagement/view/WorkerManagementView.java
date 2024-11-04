package fourservings_fiveservings.insurance_system_be.team.workerManagement.view;


import fourservings_fiveservings.insurance_system_be.common.view.DepartmentView;
import fourservings_fiveservings.insurance_system_be.user.worker.Worker;
import java.util.List;

public class WorkerManagementView extends DepartmentView {

    public void showAllCustomerInfo(List<Worker> workers) {
        workers.forEach(worker -> {
            println("");
            println("직원 아이디 : " + worker.getId());
            println("직원 이름 : " + worker.getName());
            println("직원 나이 : " + worker.getAge());
            println("직원 성별 : " + worker.getSex());
            println("직원 전화번호 : " + worker.getPhoneNumber());
            println("");
        });
    }
}
