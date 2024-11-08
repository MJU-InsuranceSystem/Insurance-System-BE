package fourservings_fiveservings.insurance_system_be.user.customer;

import fourservings_fiveservings.insurance_system_be.common.vo.RequestVO;
import fourservings_fiveservings.insurance_system_be.common.vo.ResponseVO;
import fourservings_fiveservings.insurance_system_be.common.view.SystemView;
import fourservings_fiveservings.insurance_system_be.insurance.Insurance;
import fourservings_fiveservings.insurance_system_be.insurance.InsuranceList;
import fourservings_fiveservings.insurance_system_be.insurance.InsuranceType;
import java.util.List;
import java.util.Objects;

public class CustomerSystem {

    private final SystemView systemView;
    private final CustomerView customerView;
    private final CustomerProcessManager customerProcessManager;
    private final InsuranceList insuranceList;

    public CustomerSystem(SystemView systemView, CustomerView customerView,
        CustomerProcessManager customerProcessManager, InsuranceList insuranceList) {
        this.systemView = systemView;
        this.customerView = customerView;
        this.customerProcessManager = customerProcessManager;
        this.insuranceList = insuranceList;
    }

    public void process() {
        while (true) {
            try {
                int processNumber = systemView.selectCustomerProcess();
                if (processNumber == 0) {
                    break;
                }
                CustomerProcess process = CustomerProcess.findByNumber(processNumber);
                startProcess(process);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void startProcess(CustomerProcess process) {
        switch (process) {
            case APPLY_INSURANCE_JOIN -> {
//                applyInsuranceJoin();
                int selectInsurance = customerView.selectInsuranceNumber();
                InsuranceType insuranceType = InsuranceType.findByNumber(selectInsurance);
                List<Insurance> insurances = insuranceList.findAll();
                List<Insurance> selectInsurances = classifyInsurance(insurances, insuranceType);
                if (!selectInsurances.isEmpty()) {
                    RequestVO requestVO = customerView.requireInsuranceInfo(selectInsurances);
                    Insurance insurance = insuranceList.findById(
                        Integer.parseInt(requestVO.get(CustomerView.INSURANCE_NUMBER)));
                    customerProcessManager.applyInsurance(requestVO, insurance);
                    customerView.successTask();
                    return;
                }
                customerView.emptyInsuranceInfo();
            }
            case PAY_INSURANCE_PREMIUM -> {
                ResponseVO responseVO = customerProcessManager.getAccountOfInsurance();
                if (customerView.showAccountOfInsurance(responseVO)) {
                    RequestVO requestVO = customerView.payInsurancePremiumInfo();
                    customerProcessManager.payInsurancePremium(requestVO);
                    customerView.successTask();
                }
            }
            case REQUIRE_INSURANCE_BENEFIT -> {
                RequestVO requestVO = customerView.requireInsuranceBenefitInfo();
                ResponseVO responseVO = customerProcessManager.requireInsuranceBenefit(requestVO);
                customerView.completeSubmitAccident(responseVO);
            }
            case RETRIEVE_CONTRACT -> {
                customerView.retrieveContract(customerProcessManager.retrieveContract());
            }
            default -> throw new IllegalArgumentException("선택하신 업무가 존재하지 않습니다");
        }
    }

    private List<Insurance> classifyInsurance(List<Insurance> insurances,
        InsuranceType insuranceType) {
        return insurances.stream()
            .filter(insurance -> Objects.equals(insurance.getInsuranceType(), insuranceType))
            .toList();
    }

    private void applyInsuranceJoin() {
        int insuranceNumber = customerView.selectInsuranceNumber();
        InsuranceType insuranceType = InsuranceType.findByNumber(insuranceNumber);
        switch (insuranceType) {
            case FIRE -> {
                RequestVO requestVO = customerView.requireFireInfo();
                customerProcessManager.applyFireInsurance(requestVO);
            }
            case LIFE -> {
                RequestVO requestVO = customerView.requireLifeInfo();
                customerProcessManager.applyLifeInsurance(requestVO);
            }
            case TRAVEL -> {
                RequestVO requestVO = customerView.requireTravelInfo();
                customerProcessManager.applyTravelInsurance(requestVO);
            }
            case CAR -> {
                RequestVO requestVO = customerView.requireCarInfo();
                customerProcessManager.applyCarInsurance(requestVO);
            }
            case CANCER -> {
                RequestVO requestVO = customerView.requireCancerInfo();
                customerProcessManager.applyCancerInsurance(requestVO);
            }
            default -> throw new IllegalArgumentException("해당 번호의 보험은 존재하지 않습니다.");
        }
    }
}
