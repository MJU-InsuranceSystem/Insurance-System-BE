package fourservings_fiveservings.insurance_system_be.domain.insurance.type;

import fourservings_fiveservings.insurance_system_be.team.contract.entity.InsuranceApplication;

/**
 * @author USER
 * @version 1.0
 */
public class TravelInsuranceApplication extends InsuranceApplication {

    private String destination;
    private int numberOfTravelers;
    private String travelPeriod;

    public TravelInsuranceApplication() {

    }

    public void finalize() throws Throwable {
        super.finalize();
    }

}