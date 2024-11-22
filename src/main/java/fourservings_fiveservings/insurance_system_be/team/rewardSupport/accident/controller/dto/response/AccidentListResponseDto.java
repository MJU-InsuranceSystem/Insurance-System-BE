package fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.controller.dto.response;

import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.entity.Accident;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record AccidentListResponseDto(
        Long id,
        LocalDateTime accidentDate,
        String description,
        String location,
        BigDecimal damageAmount,
        String fileUrl,
        String accidentType,
        String customerName
) {

    public static AccidentListResponseDto from(Accident accident, String fileUrl) {
        return AccidentListResponseDto.builder()
                .id(accident.getId())
                .accidentDate(accident.getAccidentDate())
                .description(accident.getDescription())
                .location(accident.getLocation())
                .damageAmount(accident.getDamageAmount())
                .fileUrl(fileUrl)
                .accidentType(accident.getFileName())
                .customerName(accident.getCustomer().getName())
                .build();
    }
}
