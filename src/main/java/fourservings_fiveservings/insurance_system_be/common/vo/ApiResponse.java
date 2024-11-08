package fourservings_fiveservings.insurance_system_be.common.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import fourservings_fiveservings.insurance_system_be.common.constant.ResultType;
import fourservings_fiveservings.insurance_system_be.common.constant.SuccessType;
import lombok.Builder;

@Builder
@JsonPropertyOrder({"httpStatusCode", "message", "data"})
public record ApiResponse<T>(
    ResultType resultType,
    int httpStatusCode,
    String message,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    T data
) {

    public static <T> ApiResponse<T> success(SuccessType successType, T data) {
        return ApiResponse.<T>builder()
            .resultType(ResultType.SUCCESS)
            .httpStatusCode(successType.getHttpStatusCode())
            .message(successType.getMessage())
            .data(data)
            .build();
    }

    public static ApiResponse<?> success(SuccessType successType) {
        return success(successType, null);
    }
}
