package fourservings_fiveservings.insurance_system_be.team.contract.controller.entity;

import fourservings_fiveservings.insurance_system_be.domain.user.entity.User;
import fourservings_fiveservings.insurance_system_be.team.contract.entity.Contract;
import fourservings_fiveservings.insurance_system_be.team.product.entity.Product;

public record ContractApplyRequestDto() {

    public static Contract toEntity(User appliedCustomer, Product product) {
        return Contract.builder()
            .user(appliedCustomer)
            .product(product)
            .build();
    }
}
