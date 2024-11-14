package fourservings_fiveservings.insurance_system_be.common.exception.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    // user
    EXIST_EMAIL(HttpStatus.CONFLICT, "USER-001", "이미 존재하는 이메일입니다."),
    NO_EXIST_EMAIL(HttpStatus.NOT_FOUND, "USER-002", "존재하지 않는 이메일 입니다."),
    MISMATCH_PASSWORD(HttpStatus.BAD_REQUEST, "USER-003", "비밀번호가 일치하지 않습니다."),

    // auth
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "AUTH-001", "토큰이 만료되었습니다."),
    INVALID_FORMAT_TOKEN(HttpStatus.BAD_REQUEST, "AUTH-002", "잘못된 JWT 형식입니다."),
    INVALID_SIGNATURE(HttpStatus.UNAUTHORIZED, "AUTH-003", "서명이 올바르지 않습니다."),
    ERROR_TOKEN(HttpStatus.BAD_REQUEST, "AUTH-004", "JWT 토큰 검증 중 오류 발생");

    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String message;
}
