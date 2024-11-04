package fourservings_fiveservings.insurance_system_be.insurance.type;

import fourservings_fiveservings.insurance_system_be.insurance.apply.InsuranceApplication;

/**
 * @author USER
 * @version 1.0
 */
public class CarInsuranceApplication extends InsuranceApplication {

    private CarKind carKind;
    private int percentageOfBlame;
    private int userDuration;

    public CarInsuranceApplication() {

    }
}