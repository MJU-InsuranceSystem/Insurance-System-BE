package fourservings_fiveservings.insurance_system_be.common.response.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuccessType {

    SUCCESS(200, "요청에 성공하였습니다."),
    CREATED(201, "성공적으로 생성하였습니다."),
    NO_CONTENT(204, "요청에 성공하였습니다.");

    private final int httpStatusCode;
    private final String message;
}

