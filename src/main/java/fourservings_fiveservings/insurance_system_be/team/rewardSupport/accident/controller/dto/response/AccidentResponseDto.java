package fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.controller.dto.response;

import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.entity.Accident;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record AccidentResponseDto(
        Long id,
        LocalDateTime accidentDate,
        String description,
        String location,
        BigDecimal damageAmount,
        String fileUrl,
        String accidentType,
        String customerName,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static AccidentResponseDto from(Accident accident, String fileUrl) {
        return AccidentResponseDto.builder()
                .id(accident.getId())
                .accidentDate(accident.getAccidentDate())
                .description(accident.getDescription())
                .location(accident.getLocation())
                .damageAmount(accident.getDamageAmount())
                .fileUrl(fileUrl)
                .accidentType(accident.getFileName())
                .customerName(accident.getCustomer().getName())
                .createdAt(accident.getCreatedAt())
                .updatedAt(accident.getUpdatedAt())
                .build();
    }
}
