package fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.controller.dto.response;

import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.entity.Accident;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record AccidentListResponseDto(
        Long id,
        String title,
        LocalDateTime accidentDate,
        BigDecimal damageAmount,
        String accidentType,
        String liabilityStatus
) {

    public static AccidentListResponseDto from(Accident accident) {
        return AccidentListResponseDto.builder()
                .id(accident.getId())
                .title(accident.getTitle())
                .accidentDate(accident.getAccidentDate())
                .damageAmount(accident.getDamageAmount())
                .accidentType(accident.getAccidentType().getName())
                .liabilityStatus(accident.getLiabilityStatus().getDescription())
                .build();
    }
}
