package fourservings_fiveservings.insurance_system_be.team.contract.common.controller.dto.request;

import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.Contract;
import fourservings_fiveservings.insurance_system_be.team.insurance.entity.Insurance;
import fourservings_fiveservings.insurance_system_be.user.entity.Customer;

public interface CreateContractRequestDto {

    Contract createPendingContract(Customer appliedCustomer, Insurance insurance);
}
