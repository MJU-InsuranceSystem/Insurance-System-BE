package fourservings_fiveservings.insurance_system_be.user.auth;

import fourservings_fiveservings.insurance_system_be.user.customer.CustomerList;
import fourservings_fiveservings.insurance_system_be.user.worker.WorkerList;
import java.util.Arrays;

public enum AuthProcessType {
    LOGIN(1, new LoginProcess(CustomerList.getInstance(), WorkerList.getInstance())),
    SIGN_UP(2, new SignUpProcess(CustomerList.getInstance(), WorkerList.getInstance()));

    private final int processNumber;
    private final Process process;

    AuthProcessType(int processNumber, Process process) {
        this.processNumber = processNumber;
        this.process = process;
    }

    public int getProcessNumber() {
        return this.processNumber;
    }

    public Process getProcess() {
        return this.process;
    }

    public static AuthProcessType findProcessType(int processNumber) {
        return Arrays.stream(AuthProcessType.values())
            .filter(process -> process.getProcessNumber() == processNumber)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("해당 프로세스 번호는 존재하지 않습니다."));
    }
}
