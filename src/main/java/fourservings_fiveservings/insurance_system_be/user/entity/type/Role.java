package fourservings_fiveservings.insurance_system_be.user.entity.type;

import fourservings_fiveservings.insurance_system_be.common.exception.ResourceNotFoundException;
import fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@Getter
@RequiredArgsConstructor
public enum Role {
    CONTRACT("계약 관리 팀"),
    PLAN("상품 기획 팀"),
    REWARD_SUPPORT("보상 지원 팀"),
    INSURANCE("보험 관리 팀"),
    UNDER_WRITE("UW 팀"),
    PAYMENT("납부 관리 팀");

    private final String label;

    public static Role findByName(String label) {
        return Arrays.stream(Role.values())
                .filter(role -> Objects.equals(role.getLabel(), label))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException(ErrorType.RESOURCE_NOT_FOUND));
    }
}
