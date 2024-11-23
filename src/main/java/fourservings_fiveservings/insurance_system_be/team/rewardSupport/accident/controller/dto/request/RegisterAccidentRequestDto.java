package fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.controller.dto.request;


import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.common.Contract;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.entity.Accident;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.entity.AccidentType;
import fourservings_fiveservings.insurance_system_be.user.entity.Customer;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.web.multipart.MultipartFile;

public record RegisterAccidentRequestDto(
    String title,
    LocalDateTime accidentDate,
    String description,
    String location,
    BigDecimal damageAmount,
    String accidentType,
    MultipartFile file
) {

    public Accident toAccident(Customer customer, Contract contract, String uploadedFileName) {
        return Accident.builder()
            .title(title)
            .accidentDate(accidentDate)
            .description(description)
            .location(location)
            .damageAmount(damageAmount)
            .accidentType(AccidentType.findByName(accidentType))
            .fileName(uploadedFileName)
            .customer(customer)
            .contract(contract)
            .build();
    }
}
