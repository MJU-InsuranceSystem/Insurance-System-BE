package fourservings_fiveservings.insurance_system_be.user.customer;


import static fourservings_fiveservings.insurance_system_be.user.customer.CustomerView.ACCIDENT_CONTENT;
import static fourservings_fiveservings.insurance_system_be.user.customer.CustomerView.ACCIDENT_NAME;
import static fourservings_fiveservings.insurance_system_be.user.customer.CustomerView.CHARGE_ANSWER;
import static fourservings_fiveservings.insurance_system_be.user.customer.CustomerView.CLAIMINSURANCE_ACCOUNT;
import static fourservings_fiveservings.insurance_system_be.user.customer.CustomerView.CLAIMINSURANCE_ADDRESS;
import static fourservings_fiveservings.insurance_system_be.user.customer.CustomerView.CLAIMINSURANCE_PHONENUMBER;
import static fourservings_fiveservings.insurance_system_be.user.customer.CustomerView.CLAIMINSURANCE_RESIDENTNUMBER;
import static fourservings_fiveservings.insurance_system_be.user.customer.CustomerView.CLAIMINSURANCE_SUPPORTINGFILE;

import fourservings_fiveservings.insurance_system_be.common.AuthUtil;
import fourservings_fiveservings.insurance_system_be.common.dto.RequestVO;
import fourservings_fiveservings.insurance_system_be.common.dto.ResponseVO;
import fourservings_fiveservings.insurance_system_be.insurance.Insurance;
import fourservings_fiveservings.insurance_system_be.insurance.apply.InsuranceApplication;
import fourservings_fiveservings.insurance_system_be.insurance.apply.InsuranceApplyList;
import fourservings_fiveservings.insurance_system_be.insurance.apply.InsuranceChargeCustomerApplyList;
import fourservings_fiveservings.insurance_system_be.team.contract.Contract;
import fourservings_fiveservings.insurance_system_be.team.plan.Status;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.model.Accident;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.model.AccidentList;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.model.ClaimInsurance;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.model.InsurancePremiumPaymentCustomerList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomerProcessManager {

    private final InsuranceApplyList insuranceApplyList;
    private final InsuranceChargeCustomerApplyList insuranceChargeCustomerApplyList;
    private final InsurancePremiumPaymentCustomerList insurancePremiumPaymentCustomerList;
    private final AccidentList accidentList;

    public CustomerProcessManager(InsuranceApplyList insuranceApplyList,
        InsuranceChargeCustomerApplyList insuranceChargeCustomerApplyList,
        AccidentList accidentList,
        InsurancePremiumPaymentCustomerList insurancePremiumPaymentCustomerList) {
        this.insuranceApplyList = insuranceApplyList;
        this.insuranceChargeCustomerApplyList = insuranceChargeCustomerApplyList;
        this.accidentList = accidentList;
        this.insurancePremiumPaymentCustomerList = insurancePremiumPaymentCustomerList;
    }

    public List<Contract> retrieveContract() {
        Customer loginUser = (Customer) AuthUtil.user;
//        return loginUser.getContractList();
        return null;
    }

    public void applyInsurance(RequestVO requestVO, Insurance insurance) {
        InsuranceApplication insuranceApplication = new InsuranceApplication();
        int insuranceApplicationId = Integer.parseInt(
            requestVO.get(CustomerView.INSURANCE_APPLICATION_ID));
        String subscriberName = requestVO.get(CustomerView.SUBSCRIBER_NAME);
        String personalInfo = requestVO.get(CustomerView.PERSONAL_INFO);
        String familyHistory = requestVO.get(CustomerView.FAMILY_HISTORY);
        String requestInsurance = requestVO.get(CustomerView.REQUEST_INSURANCE);

        insuranceApplication.setInsuranceApplicationID(insuranceApplicationId);
        insuranceApplication.setSubscriberName(subscriberName);
        insuranceApplication.setPersonalInfo(personalInfo);
        insuranceApplication.setFamilyHistory(familyHistory);
        insuranceApplication.setRequestInsurance(requestInsurance);
        insuranceApplication.setInsurance(insurance);
        insuranceApplyList.add(insuranceApplication);
    }

    public void payInsurancePremium(RequestVO requestVO) {
        Customer customer = (Customer) AuthUtil.user;
        String premiumAnswer = requestVO.get(CustomerView.PREMIUM_ANSWER);
        if (premiumAnswer.equals("Y") || premiumAnswer.equals("y")) {
            insurancePremiumPaymentCustomerList.add(customer);
        }
    }

    public ResponseVO requireInsuranceBenefit(RequestVO request) {
        ResponseVO responseVO = new ResponseVO();

        if (request.get(CHARGE_ANSWER).equals("Y") || request.get(CHARGE_ANSWER).equals("y")) {
            Customer loginUser = (Customer) AuthUtil.user;
            insuranceChargeCustomerApplyList.add(loginUser);

            Accident accident = new Accident();
            accident.setContent(request.get(ACCIDENT_CONTENT));
            accident.setCustomerName(request.get(ACCIDENT_NAME));

            ClaimInsurance claimInsurance = new ClaimInsurance();
            claimInsurance.setAccount(request.get(CLAIMINSURANCE_ACCOUNT));
            claimInsurance.setAddress(request.get(CLAIMINSURANCE_ADDRESS));
            claimInsurance.setPhoneNumber(request.get(CLAIMINSURANCE_PHONENUMBER));
            claimInsurance.setResidentNumber(request.get(CLAIMINSURANCE_RESIDENTNUMBER));
            claimInsurance.setSupportingFile(request.get(CLAIMINSURANCE_SUPPORTINGFILE));

            accident.setClaimInsurance(claimInsurance);

            for (Map.Entry<String, String> entry : request.getTotalInfo().entrySet()) {
                if (entry.getValue() == null) {
                    responseVO.add(Status.getKey(), Status.INPUT_EMPTY.getStatus());
                    return responseVO;
                }
            }
            boolean check = accidentList.add(accident);

            if (!check) {
                responseVO.add(Status.getKey(), Status.FAIL.getStatus());
                return responseVO;
            }
            responseVO.add(Status.getKey(), Status.SUCCESS.getStatus());
            return responseVO;
        }
        responseVO.add(Status.getKey(), Status.FAIL.getStatus());
        return responseVO;
    }

    public void applyFireInsurance(RequestVO requestVO) {
    }

    public void applyLifeInsurance(RequestVO requestVO) {
    }

    public void applyTravelInsurance(RequestVO requestVO) {
    }

    public void applyCarInsurance(RequestVO requestVO) {
    }

    public void applyCancerInsurance(RequestVO requestVO) {
    }

    public ResponseVO getAccountOfInsurance() {
        Customer customer = (Customer) AuthUtil.user;
        ResponseVO responseVO = new ResponseVO();
        if (insurancePremiumPaymentCustomerList.contains(customer)) {
            responseVO.add(CustomerView.CHECK_PAID, "Y");
            return responseVO;
        }
//        List<Contract> contracts = customer.getContractList();
        List<Contract> contracts = null;
        String insurances = contracts.stream()
            .map(contract -> contract.getInsuranceApplication().getInsurance().getInsuranceType()
                .getDescription())
            .collect(Collectors.joining(", "));

        int totalAccount = contracts.stream()
            .mapToInt(contract -> contract.getInsuranceApplication().getInsurance().getReward()
                .getMonthPaymentFee())
            .sum();

        responseVO.add(CustomerView.CHECK_PAID, "N");
        responseVO.add(CustomerView.SUBSCRIBE_INSURANCE, insurances);
        responseVO.add(CustomerView.TOTAL_ACCOUNT, String.valueOf(totalAccount));
        return responseVO;
    }
}
