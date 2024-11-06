package fourservings_fiveservings.insurance_system_be.team.contract;

import static fourservings_fiveservings.insurance_system_be.user.customer.CustomerList.CUSTOMER_MANAGER;

import fourservings_fiveservings.insurance_system_be.common.dto.RequestVO;
import fourservings_fiveservings.insurance_system_be.common.dto.ResponseVO;
import fourservings_fiveservings.insurance_system_be.insurance.apply.InsuranceApplication;
import fourservings_fiveservings.insurance_system_be.insurance.apply.InsuranceApplyList;
import fourservings_fiveservings.insurance_system_be.team.TeamMethod;
import fourservings_fiveservings.insurance_system_be.team.underwrite.view.UnderwriteView;
import fourservings_fiveservings.insurance_system_be.user.customer.Customer;

public class ContractManagementTeamMethod extends TeamMethod {

    private final ContractList contractList;
    private final InsuranceApplyList insuranceApplyList;
    private static int order = 0;


    public ContractManagementTeamMethod(ContractList contractList,
        InsuranceApplyList insuranceApplyList) {
        this.contractList = contractList;
        this.insuranceApplyList = insuranceApplyList;
    }

    @Override
    public ResponseVO manage(RequestVO request) {
        return null;
    }

    @Override
    public ResponseVO process(RequestVO request) {
        return null;
    }

    @Override
    public ResponseVO register(RequestVO request) {
        Customer applyCustomer = CUSTOMER_MANAGER.findByName(
                request.get(UnderwriteView.FINISH_INSURANCE_CUSTOMER_NAME))
            .orElseThrow(NullPointerException::new);
        int insuranceId = Integer.parseInt(request.get(UnderwriteView.FINISH_INSURANCE_ID));
        InsuranceApplication insuranceApplication = insuranceApplyList.findById(insuranceId);
        String customerName = request.get(UnderwriteView.FINISH_INSURANCE_CUSTOMER_NAME);

        Contract contract = new Contract();
        contract.setId(order++);
        contract.setInsurance(insuranceApplication);
        contract.setManagerName("모델들이 하는 모델링");
        contract.setCustomerName(customerName);
//        applyCustomer.getContractList().add(contract);
        contractList.add(contract);
        insuranceApplyList.remove(insuranceApplication);

        ResponseVO responseVO = new ResponseVO();
        responseVO.add(UnderwriteView.CONTRACT_INFO, contract.toString());
        return responseVO;
    }

    @Override
    public ResponseVO remove(RequestVO request) {
        return null;
    }

    @Override
    public ResponseVO retrieve(RequestVO request) {
        return null;
    }

    public ContractList retrieveContracts() {
        return contractList;
    }

    public void deleteContract(RequestVO requestVO) {
        int contractId = Integer.parseInt(requestVO.get(ContractManagementView.CONTRACT_ID));
        contractList.removeById(contractId);
    }
}
