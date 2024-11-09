package fourservings_fiveservings.insurance_system_be.common.exception.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    // User
    EXIST_EMAIL(HttpStatus.CONFLICT, "USER-001", "이미 존재하는 이메일입니다."),
    NO_EXIST_EMAIL(HttpStatus.NOT_FOUND, "USER-002", "존재하지 않는 이메일 입니다."),
    MISMATCH_PASSWORD(HttpStatus.BAD_REQUEST, "USER-003", "비밀번호가 일치하지 않습니다.");


    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String message;
}
