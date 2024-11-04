package fourservings_fiveservings.insurance_system_be.common.exception;

public class EmptyInputException extends RuntimeException{

  private String message;
  public EmptyInputException(String message) {
    super(message);
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
