package fourservings_fiveservings.insurance_system_be.common.exception.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    NO_EXIST_ACCIDENT(HttpStatus.NOT_FOUND, "ACCIDENT-001", "사건 정보가 존재하지 않습니다."),

    // contract
    NO_EXIST_CONTRACT(HttpStatus.NOT_FOUND, "CONTRACT-001", "계약 정보가 존재하지 않습니다."),
    NO_EXIST_APPROVE_TYPE(HttpStatus.NOT_FOUND, "CONTRACT-002", "타입변환할 Approve 타입이 없습니다."),
    NO_EXIST_PAYMENT_METHOD(HttpStatus.NOT_FOUND, "CONTRACT-003", "타입 변환활 Payment method가없습니다."),

    // payment
    INSUFFICIENT_BALANCE(HttpStatus.BAD_REQUEST, "PAYMENT-001", "통장에 돈이 충분하지 않습니다."),
    INVALID_PAYMENT_AMOUNT(HttpStatus.BAD_REQUEST, "PAYMENT-002", "월 납부액과 일치하지 않습니다."),

    // user
    EXIST_EMAIL(HttpStatus.CONFLICT, "USER-001", "이미 존재하는 이메일입니다."),
    NO_EXIST_EMAIL(HttpStatus.NOT_FOUND, "USER-002", "존재하지 않는 이메일 입니다."),
    MISMATCH_PASSWORD(HttpStatus.BAD_REQUEST, "USER-003", "비밀번호가 일치하지 않습니다."),
    NO_EXIST_USER_TYPE(HttpStatus.BAD_REQUEST, "USER-004", "타입변환할 USER 타입이 없습니다."),
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "USER-005", "해당 자원을 찾을 수 없습니다."),
    NO_EXIST_ACCOUNT_INFO(HttpStatus.BAD_REQUEST, "USER-005", "계좌 정보가 없습니다."),
    INVALID_BANK_NAME(HttpStatus.BAD_REQUEST, "USER-006", "은행 이름이 올바르지 않습니다."),
    NO_EXIST_USER(HttpStatus.NOT_FOUND, "USER-007", "존재하지 않는 유저입니다."),

    // auth
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "AUTH-001", "토큰이 만료되었습니다."),
    INVALID_FORMAT_TOKEN(HttpStatus.BAD_REQUEST, "AUTH-002", "잘못된 JWT 형식입니다."),
    INVALID_SIGNATURE(HttpStatus.UNAUTHORIZED, "AUTH-003", "서명이 올바르지 않습니다."),
    ERROR_TOKEN(HttpStatus.BAD_REQUEST, "AUTH-004", "JWT 토큰 검증 중 오류 발생"),
    NO_EXIST_PERMISSION(HttpStatus.UNAUTHORIZED, "AUTH-005", "권한이 존재하지 않습니다."),

    //file
    NOT_SUPPORTED_FILE_FORMAT(HttpStatus.BAD_REQUEST, "FILE-001", "해당 파일 형식을 지원하지 않습니다."),
    UPLOAD_FILE_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "FILE-002", "파일 업로드를 실패했습니다."),

    //valid
    NOT_VALID_FORMAT(HttpStatus.BAD_REQUEST, "VALID-001", "입력 형식이 올바르지 않습니다.");

    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String message;
}
