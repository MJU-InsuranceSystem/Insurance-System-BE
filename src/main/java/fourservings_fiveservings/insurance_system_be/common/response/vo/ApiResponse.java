package fourservings_fiveservings.insurance_system_be.common.response.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType;
import fourservings_fiveservings.insurance_system_be.common.response.constant.ResultType;
import fourservings_fiveservings.insurance_system_be.common.response.constant.SuccessType;
import lombok.Builder;

@Builder
@JsonPropertyOrder({"httpStatusCode", "message", "data"})
public record ApiResponse<T>(
        ResultType resultType,
        int httpStatusCode,
        String responseCode,
        String message,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        T data
) {

    public static <T> ApiResponse<T> success(SuccessType successType, T data) {
        return ApiResponse.<T>builder()
                .resultType(ResultType.SUCCESS)
                .httpStatusCode(successType.getHttpStatusCode())
                .responseCode(successType.getResponseCode())
                .message(successType.getMessage())
                .data(data)
                .build();
    }

    public static ApiResponse<?> success(SuccessType successType) {
        return success(successType, null);
    }

    public static ApiResponse<?> error(final ErrorType errorType) {
        return ApiResponse.builder()
                .resultType(ResultType.ERROR)
                .httpStatusCode(errorType.getHttpStatus().value())
                .responseCode(errorType.getErrorCode())
                .message(errorType.getMessage())
                .build();
    }
}
