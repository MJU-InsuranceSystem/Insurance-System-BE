package fourservings_fiveservings.insurance_system_be.team.product.insurance.type;

import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.embaded.ContractInformation;

/**
 * @author USER
 * @version 1.0
 */
public class CarContractInformation extends ContractInformation {

    private CarKind carKind;
    private int percentageOfBlame;
    private int userDuration;

    public CarContractInformation() {

    }
}
