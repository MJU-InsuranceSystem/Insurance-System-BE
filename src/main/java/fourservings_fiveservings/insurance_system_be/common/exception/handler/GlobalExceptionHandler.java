package fourservings_fiveservings.insurance_system_be.common.exception.handler;

import fourservings_fiveservings.insurance_system_be.common.exception.BusinessException;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ApiResponse<?>> handleBusinessException(BusinessException e) {
        log.error("BusinessException", e);
        ApiResponse<?> apiResponse = ApiResponse.error(e.getErrorType());
        return ResponseEntity.status(e.getErrorType().getHttpStatus()).body(apiResponse);
    }
}