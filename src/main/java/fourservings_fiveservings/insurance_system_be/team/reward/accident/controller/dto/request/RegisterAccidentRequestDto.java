package fourservings_fiveservings.insurance_system_be.team.reward.accident.controller.dto.request;


import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.Contract;
import fourservings_fiveservings.insurance_system_be.team.reward.accident.entity.Accident;
import fourservings_fiveservings.insurance_system_be.team.reward.accident.entity.type.AccidentType;
import fourservings_fiveservings.insurance_system_be.team.reward.accident.entity.type.LiabilityStatus;
import fourservings_fiveservings.insurance_system_be.user.entity.Customer;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
                .liabilityStatus(LiabilityStatus.PENDING)
                .build();
    }
}
