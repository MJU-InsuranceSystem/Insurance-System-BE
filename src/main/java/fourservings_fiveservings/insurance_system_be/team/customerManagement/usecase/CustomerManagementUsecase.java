package fourservings_fiveservings.insurance_system_be.team.customerManagement.usecase;

import fourservings_fiveservings.insurance_system_be.common.usecase.Usecase;
import java.util.Arrays;

public enum CustomerManagementUsecase implements Usecase {
    ALL_CUSTOMER_RETRIEVE(1, "모든 고객 조회");

    private final int order;
    private final String description;

    CustomerManagementUsecase(int order, String description) {
        this.order = order;
        this.description = description;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public static CustomerManagementUsecase findByNumber(int selectNumber) {
        return Arrays.stream(CustomerManagementUsecase.values())
            .filter(usecase -> usecase.getOrder() == selectNumber)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("해당 유스케이스 번호를 찾을 수 없습니다."));
    }
}
