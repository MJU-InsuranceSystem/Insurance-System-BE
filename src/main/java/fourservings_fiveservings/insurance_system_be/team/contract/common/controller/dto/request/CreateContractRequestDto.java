package fourservings_fiveservings.insurance_system_be.team.contract.common.controller.dto.request;

import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.common.Contract;
import fourservings_fiveservings.insurance_system_be.team.insurance.entity.Insurance;
import fourservings_fiveservings.insurance_system_be.user.entity.User;

public interface CreateContractRequestDto {

    Contract createPendingContract(User appliedCustomer, Insurance insurance);
}
