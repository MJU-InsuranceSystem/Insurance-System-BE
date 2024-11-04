package fourservings_fiveservings.insurance_system_be.team.underwrite.usecase;

import fourservings_fiveservings.insurance_system_be.common.exception.IsNotExistException;
import fourservings_fiveservings.insurance_system_be.common.usecase.Usecase;
import java.util.Arrays;

public enum UnderwriteUsecase implements Usecase {
    ESTABLISH_UNDERWRITING_POLICY(1, "인수 정책을 수립하다."),
    PERFORM_UNDERWRITING(2, "인수를 심사하다."),
    REQUIRE_CO_UNDERWRITING(3, "공동 인수를 요청하다");

    private final int order;
    private final String description;

    UnderwriteUsecase(int order, String description) {
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

    public static UnderwriteUsecase findByNumber(int selectNumber) {
        return Arrays.stream(UnderwriteUsecase.values())
            .filter(usecase -> usecase.getOrder() == selectNumber)
            .findFirst()
            .orElseThrow(() -> new IsNotExistException("해당 유스케이스 번호를 찾을 수 없습니다."));
    }
}
