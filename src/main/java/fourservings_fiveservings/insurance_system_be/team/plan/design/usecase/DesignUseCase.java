package fourservings_fiveservings.insurance_system_be.team.plan.design.usecase;

import fourservings_fiveservings.insurance_system_be.common.usecase.Usecase;
import java.util.Arrays;

public enum DesignUseCase implements Usecase {
    PLAN_INSURANCE(1, "상품을 기획한다."),
    DESIGN_INSURANCE(2, "상품을 설계한다."),
    ASK_INSURANCE_AUTHORIZATION(3, "상품 인가를 요청한다."),
    MANAGE_INSURANCE(4, "상품을 사후 관리하다.");
    private final int order;
    private final String description;


    DesignUseCase(int order, String description) {
        this.order = order;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getOrder() {
        return order;
    }

    public static DesignUseCase findByNumber(int selectNumber) {
        return Arrays.stream(DesignUseCase.values())
            .filter(usecase -> usecase.getOrder() == selectNumber)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("해당 유스케이스 번호를 찾을 수 없습니다."));
    }
}
