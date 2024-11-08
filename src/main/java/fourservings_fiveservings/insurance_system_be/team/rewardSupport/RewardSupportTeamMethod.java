package fourservings_fiveservings.insurance_system_be.team.rewardSupport;

import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.ENTITY_LIST;
import static fourservings_fiveservings.insurance_system_be.team.rewardSupport.view.RewardSupportView.ACCIDENT_NAME;
import static fourservings_fiveservings.insurance_system_be.team.rewardSupport.view.RewardSupportView.CLAIMINSURANCE_ACCOUNT;
import static fourservings_fiveservings.insurance_system_be.team.rewardSupport.view.RewardSupportView.JUDGE_ANSWER;
import static fourservings_fiveservings.insurance_system_be.team.rewardSupport.view.RewardSupportView.NOT_PAID_CUSTOMER;
import static fourservings_fiveservings.insurance_system_be.team.rewardSupport.view.RewardSupportView.PAY_ANSWER;

import fourservings_fiveservings.insurance_system_be.common.vo.RequestVO;
import fourservings_fiveservings.insurance_system_be.common.vo.ResponseVO;
import fourservings_fiveservings.insurance_system_be.insurance.apply.InsuranceChargeCustomerApplyList;
import fourservings_fiveservings.insurance_system_be.team.TeamMethod;
import fourservings_fiveservings.insurance_system_be.team.plan.Status;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.model.Accident;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.model.AccidentList;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.model.InsurancePremiumPaymentCustomerList;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.model.LitigationInfoList;
import fourservings_fiveservings.insurance_system_be.user.customer.Customer;
import fourservings_fiveservings.insurance_system_be.user.customer.CustomerList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author USER
 * @version 1.0
 */
public class RewardSupportTeamMethod extends TeamMethod {

    private final AccidentList accidentList;
    private final LitigationInfoList litigationInfoList;

    private final InsuranceChargeCustomerApplyList insuranceChargeCustomerApplyList;
    private final InsurancePremiumPaymentCustomerList insurancePremiumPaymentCustomerList;

    private static boolean judgmentResult = false;

    public RewardSupportTeamMethod(AccidentList accidentList, LitigationInfoList litigationInfoList,
        InsuranceChargeCustomerApplyList insuranceChargeCustomerApplyList,
        InsurancePremiumPaymentCustomerList insurancePremiumPaymentCustomerList) {
        this.accidentList = accidentList;
        this.litigationInfoList = litigationInfoList;
        this.insuranceChargeCustomerApplyList = insuranceChargeCustomerApplyList;
        this.insurancePremiumPaymentCustomerList = insurancePremiumPaymentCustomerList;
    }

    public void finalize() throws Throwable {

    }

    @Override
    public ResponseVO manage(RequestVO request) {
        return null;
    }

    @Override
    public ResponseVO process(RequestVO request) {
        ResponseVO responseVO = new ResponseVO();

        if (request.get(JUDGE_ANSWER).equals("Y") || request.get(JUDGE_ANSWER).equals("y")) {
            // 면부책을 판단한다
            Accident accident = accidentList.read(0);
            if (accident == null) {
                judgmentResult = false;
                responseVO.add(Status.getKey(), Status.EMPTY.getStatus());
                return responseVO;
            }
            judgmentResult = true;
            responseVO.add(Status.getKey(), Status.SUCCESS.getStatus());
        } else if (request.get(JUDGE_ANSWER).equals("N") || request.get(JUDGE_ANSWER).equals("n")) {
            responseVO.add(Status.getKey(), Status.FAIL.getStatus());
        } else {
            responseVO.add(Status.getKey(), Status.INPUT_INVALID.getStatus());
        }
        return responseVO;
    }

    @Override
    public ResponseVO register(RequestVO request) {
        ResponseVO responseVO = new ResponseVO();

        if (judgmentResult) {
            String showJudge = "면부책 판단에 통과하였습니다.";
            responseVO.add(PAY_ANSWER, showJudge);
        } else {
            String showJudge = "면부책 판단에 탈락하였습니다.";
            responseVO.add(PAY_ANSWER, showJudge);
        }
        return responseVO;
    }

    @Override
    public ResponseVO remove(RequestVO request) {
        return null;
    }

    @Override
    public ResponseVO retrieve(RequestVO request) {
        ResponseVO responseVO = new ResponseVO();

        if (request.isEmpty()) {
            for (Accident accident : accidentList.getAllAccidents()) {
                responseVO.add(ENTITY_LIST, accident.toString());
            }
            return responseVO;
        }

        if (judgmentResult) {
            judgmentResult = false;
            Accident accident = accidentList.read(0);
            responseVO.add(ACCIDENT_NAME, accident.getCustomerName());
            responseVO.add(CLAIMINSURANCE_ACCOUNT, accident.getClaimInsurance().getAccount());
            responseVO.add(Status.getKey(), Status.SUCCESS.getStatus());
            return responseVO;
        }
        responseVO.add(Status.getKey(), Status.FAIL.getStatus());
        return responseVO;
    }

    public ResponseVO getNotPaidCustomer() {
        List<Customer> paidCustomers = insurancePremiumPaymentCustomerList.getAll();
        List<Customer> allCustomers = CustomerList.getInstance().getCustomerList();
        List<Customer> unpaidCustomers = allCustomers.stream()
            .filter(customer -> !paidCustomers.contains(customer))
            .toList();
        String notPaidCustomers = unpaidCustomers.stream()
            .map(Customer::getName)
            .collect(Collectors.joining("\n"));

        ResponseVO responseVO = new ResponseVO();
        if (!unpaidCustomers.isEmpty()) {
            responseVO.add(NOT_PAID_CUSTOMER, notPaidCustomers);
        } else {
            responseVO.add(NOT_PAID_CUSTOMER, "모든 고객이 납부하였습니다.");
        }
        return responseVO;
    }
}