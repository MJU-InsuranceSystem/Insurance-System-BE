package fourservings_fiveservings.insurance_system_be.team.plan;

public enum Status {
    SUCCESS("200"),
    FAIL("400"),
    INPUT_INVALID("invalid"),
    INPUT_EMPTY("input_empty"),
    EMPTY("empty");
    private final String status;
    private static final String KEY = "status";
    public static final String SUCCESS_NUMBER = "200";
    public static final String FAIL_NUMBER = "400";


    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static String getKey() {
        return KEY;
    }
}
