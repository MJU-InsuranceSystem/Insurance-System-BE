package fourservings_fiveservings.insurance_system_be.common.exception;

import fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType;
import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException{

    private final ErrorType errorType;

    public ResourceNotFoundException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}
