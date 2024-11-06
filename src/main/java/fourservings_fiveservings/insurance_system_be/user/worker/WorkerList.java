package fourservings_fiveservings.insurance_system_be.user.worker;

import fourservings_fiveservings.insurance_system_be.user.UserType;
import fourservings_fiveservings.insurance_system_be.user.entity.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WorkerList {

    private static final WorkerList WORKER_MANAGER = new WorkerList();
    private final List<Worker> workers = new ArrayList<>();

    private WorkerList() {

    }

    public static WorkerList getInstance() {
        return WORKER_MANAGER;
    }

    public void add(Worker worker) {
        workers.add((worker));
    }

    public boolean isExistByIdAndPassword(String id, String password) {
        return workers.stream()
            .anyMatch(worker -> worker.getId().equals(id) && worker.getPassword().equals(password));
    }

    public Optional<Worker> findByIdAndPassword(String id, String password) {
        return workers.stream()
            .filter(worker -> worker.getId().equals(id) && worker.getPassword().equals(password))
            .findFirst();
    }

    public List<Worker> getWorkerList() {
        return workers;
    }
}
