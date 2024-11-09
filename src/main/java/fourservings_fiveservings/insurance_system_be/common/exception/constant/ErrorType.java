package fourservings_fiveservings.insurance_system_be.common.exception.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    EXIST_USER(HttpStatus.CONFLICT, "USER-001", "이미 존재하는 유저입니다.");

    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String message;
}
