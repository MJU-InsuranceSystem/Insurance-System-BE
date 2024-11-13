package fourservings_fiveservings.insurance_system_be.team.contract.controller.dto;

import fourservings_fiveservings.insurance_system_be.team.contract.entity.Contract;
import fourservings_fiveservings.insurance_system_be.team.product.entity.Product;
import fourservings_fiveservings.insurance_system_be.user.entity.User;

public record ContractApplyRequestDto(

) {

    public static Contract toEntity(User appliedCustomer, Product product) {
        return Contract.builder()
            .subscriber(appliedCustomer)
            .product(product)
            .build();
    }
}
