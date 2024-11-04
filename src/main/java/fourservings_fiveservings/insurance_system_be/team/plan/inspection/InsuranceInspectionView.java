package fourservings_fiveservings.insurance_system_be.team.plan.inspection;


import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.ENTITY;
import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.INSURANCE_NAME;
import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.RESPONSIBLE_PERSON;
import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.RESTRICTION_REGULATION;
import static fourservings_fiveservings.insurance_system_be.insurance.reward.RewardConstant.INSURANCE_RATE;
import static fourservings_fiveservings.insurance_system_be.insurance.reward.RewardConstant.MAX_REWARD;
import static fourservings_fiveservings.insurance_system_be.insurance.reward.RewardConstant.MONTH_PAYMENT_FEE;
import static fourservings_fiveservings.insurance_system_be.user.customer.CustomerView.INSURANCE_NUMBER;

import fourservings_fiveservings.insurance_system_be.common.dto.RequestVO;
import fourservings_fiveservings.insurance_system_be.common.dto.ResponseVO;
import fourservings_fiveservings.insurance_system_be.common.view.DepartmentView;
import fourservings_fiveservings.insurance_system_be.team.plan.design.model.proposal.ProposalConstant;

public class InsuranceInspectionView extends DepartmentView {

    public RequestVO authorizationInsurance(ResponseVO responseVO) {
        String insuranceId = responseVO.get(INSURANCE_NUMBER);
        String insuranceName = responseVO.get(INSURANCE_NAME);
        String insuranceKind = responseVO.get(ProposalConstant.INSURANCE_KIND);
        String person = responseVO.get(RESPONSIBLE_PERSON);
        String maxPay = responseVO.get(MAX_REWARD);
        String monthPay = responseVO.get(MONTH_PAYMENT_FEE);
        String rate = responseVO.get(INSURANCE_RATE);
        String restriction = responseVO.get(RESTRICTION_REGULATION);

        println("보험 번호: " + insuranceId + " 보험 이름: " + insuranceName + " 보험 종류: " + insuranceKind
            + " 책임자: "
            + person + "\n최대 보상액: " + maxPay
            + " 월 보험료: " + monthPay + " 보험요율: " + rate + " 제약 사항: " + restriction);
        // 상품 설계안을 보여주는 로직
        RequestVO requestVO = new RequestVO();
        requestVO.add(ProposalConstant.KIND, "인가");
        requestVO.add(INSURANCE_NUMBER, insuranceId);
        println("이 보험 상품에 대한 인가를 허가 하겠습니까?\nY/N");
        requestVO.add("인가응답", writeString());
        println("인가 결정 날짜를 입력해주세요.");
        requestVO.add("날짜", writeString());
        println("인가를 결정한 담당자 이름을 입력해주세요.");
        requestVO.add("책임자이름", writeString());
        println("결정에 대한 사유를 입력해주세요.");
        requestVO.add("reason", writeString());
        requestVO.add(ENTITY, responseVO.get(ENTITY));
        return requestVO;
    }

}
