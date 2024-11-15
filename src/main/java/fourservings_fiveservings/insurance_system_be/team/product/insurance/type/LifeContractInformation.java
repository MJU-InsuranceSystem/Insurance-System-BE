package fourservings_fiveservings.insurance_system_be.team.product.insurance.type;


import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.embaded.ContractInformation;

/**
 * @author USER
 * @version 1.0
 */
public class LifeContractInformation extends ContractInformation {

    private String exclusions;
    private String medicalHistory;

    public LifeContractInformation() {

    }

    public String getExclusions() {
        return exclusions;
    }

    public void setExclusions(String exclusions) {
        this.exclusions = exclusions;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }


    public void finalize() throws Throwable {
        super.finalize();
    }

}
