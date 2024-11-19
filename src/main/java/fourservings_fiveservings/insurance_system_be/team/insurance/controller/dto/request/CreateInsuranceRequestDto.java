package fourservings_fiveservings.insurance_system_be.team.insurance.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import fourservings_fiveservings.insurance_system_be.team.insurance.entity.Insurance;
import fourservings_fiveservings.insurance_system_be.team.insurance.entity.InsuranceType;
import fourservings_fiveservings.insurance_system_be.team.insurance.entity.SaleTarget;
import fourservings_fiveservings.insurance_system_be.user.entity.Worker;
import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateInsuranceRequestDto(
    String name,

    String description,

    int eligibleAgeMin,

    int eligibleAgeMax,

    String coverageRange,

    BigDecimal coverageAmountMax,

    int duration,

    String exclusions,

    BigDecimal monthlyPremium,

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate salesStartDate,

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate salesEndDate,

    String saleTarget,

    String insuranceType
) {

    public Insurance toEntity(Worker worker) {
        return Insurance.builder()
            .name(name)
            .description(description)
            .eligibleAgeMin(eligibleAgeMin)
            .eligibleAgeMax(eligibleAgeMax)
            .coverageRange(coverageRange)
            .coverageAmountMax(coverageAmountMax)
            .duration(duration)
            .exclusions(exclusions)
            .monthlyPremium(monthlyPremium)
            .salesStartDate(salesStartDate)
            .salesEndDate(salesEndDate)
            .saleTarget(SaleTarget.findByDescription(saleTarget))
            .insuranceType(InsuranceType.findByName(insuranceType))
            .worker(worker)
            .build();
    }
}
