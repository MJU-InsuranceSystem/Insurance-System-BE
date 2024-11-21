package fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.controller.dto.request;


import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.Contract;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.entity.Accident;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.entity.enums.AccidentType;
import fourservings_fiveservings.insurance_system_be.user.entity.Customer;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RegisterAccidentRequestDto(
        LocalDateTime accidentDate,
        String description,
        String location,
        BigDecimal damageAmount,
        String accidentType,
        MultipartFile file
) {

    public Accident toAccident(Customer customer, Contract contract, String uploadedFileName) {
        return Accident.builder()
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
