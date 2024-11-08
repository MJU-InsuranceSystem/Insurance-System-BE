package fourservings_fiveservings.insurance_system_be.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserType {
  CUSTOMER("ROLE_CUSTOMER"),
  WORKER("ROLE_WORKER"),
  ADMIN("ROLE_ADMIN");

  private final String role;

}
