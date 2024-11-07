package fourservings_fiveservings.insurance_system_be.domain.user.entity;


import fourservings_fiveservings.insurance_system_be.common.entity.BaseEntity;
import fourservings_fiveservings.insurance_system_be.domain.user.UserType;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ENTITY_TYPE")
public abstract class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String loginId;

    public String password;

    public String email;

    public String phoneNumber;

    @Embedded
    public Address address;

    public String name;

    public String birthDay;

    public UserType userType;

    protected User(String loginId, String password, String email, String phoneNumber, Address address,
        String name,
        String birthDay, UserType userType) {
        this.loginId = loginId;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.name = name;
        this.birthDay = birthDay;
        this.userType = userType;
    }
}
