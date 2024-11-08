package fourservings_fiveservings.insurance_system_be.team.plan.design.view;

import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.ALL;
import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.ENTITY;
import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.ENTITY_KIND;
import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.ENTITY_LIST;
import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.INSURANCE;
import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.INSURANCE_KIND;
import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.INSURANCE_NAME;
import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.ONE;
import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.RESPONSIBLE_PERSON;
import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.RESTRICTION_REGULATION;
import static fourservings_fiveservings.insurance_system_be.insurance.InsuranceConstant.SUBSCRIBER_RIGHTS_AND_OBLIGATION;

import fourservings_fiveservings.insurance_system_be.common.vo.RequestVO;
import fourservings_fiveservings.insurance_system_be.common.vo.ResponseVO;
import fourservings_fiveservings.insurance_system_be.common.view.DepartmentView;
import fourservings_fiveservings.insurance_system_be.insurance.InsuranceType;
import fourservings_fiveservings.insurance_system_be.insurance.reward.RewardConstant;
import fourservings_fiveservings.insurance_system_be.team.plan.Status;
import fourservings_fiveservings.insurance_system_be.team.plan.design.model.designPlan.DesignConstant;
import fourservings_fiveservings.insurance_system_be.team.plan.design.model.proposal.ProposalConstant;

public class InsurancePlanView extends DepartmentView {


    public InsurancePlanView() {
    }


    public RequestVO manageProposal() {
        return null;
    }

    public RequestVO modifyProposal() {
        return null;
    }

    public RequestVO createProposal() {
        RequestVO designRequest = new RequestVO();
        designRequest.add(ProposalConstant.KIND, ProposalConstant.PROPOSAL);

        println("상품 기획서 제목을 입력하세요.");
        designRequest.add(ProposalConstant.PROPOSAL_TITLE, writeString());

        println("상품 개요를 입력하세요.");
        designRequest.add("productOverview", writeString());

        println("조사한 시장 상황을 입력하세요.");
        designRequest.add(ProposalConstant.MARKET_RESEARCH, writeString());

        println("판매 전략을 입력하세요.");
        designRequest.add(ProposalConstant.SALE_STRATEGY, writeString());

        println("보험 납부 방법에 대해서 입력하세요.");
        designRequest.add(ProposalConstant.Insurance_Payment, writeString());

        println("예상되는 판매 대상을 입력하세요.");
        designRequest.add(ProposalConstant.SALE_TARGET, writeString());

        println("보상에 대한 정보를 입력하세요.");
        designRequest.add(ProposalConstant.REWARD, writeString());

        return askSubmit(designRequest);

    }

    private RequestVO askSubmit(RequestVO requestVO) {
        println("제출하시겠습니까?\ny/n");
        return writeString().equalsIgnoreCase("y") ? yes(requestVO) : no();
    }


    public RequestVO no() {
        return null;
    }

    public RequestVO yes(RequestVO request) {
        println("제출이 완료되었습니다.");
        return request;
    }


    public void completeObect(RequestVO requestVO) {
        System.out.println("완성");
    }

    public void completeCreateProposal(ResponseVO responseVO) {
        if (responseVO.get(Status.getKey()).equals(Status.SUCCESS.getStatus())) {
            System.out.println("상품 기획이 완료 되었습니다.");
        } else {
            System.out.println("나중에 responseDTO에 에러메시지 상태를 담도록 만들어야겠당.");
        }
    }

    public RequestVO createInsurance() {
        RequestVO requestVO = new RequestVO();
        requestVO.add(ProposalConstant.KIND, INSURANCE);
        println("지금 부터 설계하고자 하는 보험 상품에 대한 정보를 입력해주세요.");
        println("보험 종류를 선택하세요.");
        for (InsuranceType insuranceType : InsuranceType.values()) {
            println(insuranceType.getInsuranceNumber() + "번 " + insuranceType.getDescription());
        }

        String insuranceKind = writeIntToString(InsuranceType.values().length);
        requestVO.add(INSURANCE_KIND, insuranceKind);
        println("보험 이름을 입력하세요.");
        requestVO.add(INSURANCE_NAME, writeString());
        println("만든 사람의 이름을 입력하세요.");
        requestVO.add(RESPONSIBLE_PERSON, writeString());
        println("보험에 포함되는 보상 최대 액을 입력하세요.");
        requestVO.add(RewardConstant.MAX_REWARD, writeString());
        println("계약시에 제약사항을 입력해주세요.");
        requestVO.add(RESTRICTION_REGULATION, writeString());
        println("매달 내야하는 보험료를 입력해주세요.");
        requestVO.add(RewardConstant.MONTH_PAYMENT_FEE, writeString());
        println("보험요율을 입력해주세요.");
        requestVO.add(RewardConstant.INSURANCE_RATE, writeString());
        println("보험 가입자의 권리와 의무를 입력해주세요.");
        requestVO.add(SUBSCRIBER_RIGHTS_AND_OBLIGATION, writeString());

        return requestVO;
    }

    public RequestVO designProduct() {
        return null;
    }

    public void createInsurance(ResponseVO responseVO) {
        if (responseVO.get(Status.getKey()).equals(Status.SUCCESS.getStatus())) {
            System.out.println("보험 생성이 완료되었습니다.");
        }
    }

    public RequestVO requestAuthorization() {
        RequestVO requestVO = new RequestVO();
        System.out.println("만들어진 보험 리스트입니다.\n인가 요청을 할 보험 번호를 입력하세요.");
        requestVO.add(ENTITY_LIST, ALL);
        requestVO.add(ENTITY_KIND, INSURANCE);
        return requestVO;
    }

    public RequestVO requestAuthorization(ResponseVO responseVO) {
        RequestVO requestVO = new RequestVO();
        requestVO.add(ProposalConstant.KIND, "인가요청");

        responseVO.getTotalInfo().forEach(
            (key, value) -> System.out.println("보험 번호: " + key + " " + value));
        requestVO.add(ENTITY_LIST, ONE);
        requestVO.add("선택번호",
            writeIntToString(responseVO.getTotalInfo().size()));
        requestVO.add(ENTITY_KIND, INSURANCE);
        return requestVO;
    }

    public void showAuthrizationResult(ResponseVO responseVO) {
        switch (responseVO.get(Status.getKey())) {
            case Status.SUCCESS_NUMBER -> {
                System.out.println("보험에 대한 인가가 통과되었습니다.");
            }
        }
    }

    public RequestVO selectProposal(ResponseVO responseVO) {
        RequestVO requestVO = new RequestVO();
        responseVO.getTotalInfo().forEach(
            (key, value) -> System.out.println("기획안 번호: " + key + " " + value));
        println("만들어진 기획안 리스트입니다.\n설계할 기획안 번호를 입력하세요. ");
        requestVO.add("객체리스트", "한개");
        requestVO.add(ENTITY_KIND, ProposalConstant.PROPOSAL);
        requestVO.add("선택번호", writeIntToString(responseVO.getTotalInfo().size()));
        return requestVO;
    }

    public RequestVO createDesign(ResponseVO responseVO) {
        RequestVO requestVO = new RequestVO();
        requestVO.add(ProposalConstant.KIND, DesignConstant.DESIGNPLAN);
        println(responseVO.get(ENTITY));
        println("설계안 제목을 입력해주세요.");
        requestVO.add(DesignConstant.DESIGN_TITLE, writeString());
        println("설계안 책임자를 입력해주세요.");
        requestVO.add(DesignConstant.DESIGN_MANAGER, writeString());
        requestVO.add("기획서번호", responseVO.get(ENTITY).split(" ")[0]);
        return requestVO;
    }

    public void completeCreateDesignPlan(ResponseVO responseVO) {
        if (responseVO.get(Status.getKey()).equals(Status.SUCCESS.getStatus())) {
            System.out.println("설계안 대로 보험 상품 생성을 완성하였습니다.!");
        }
    }

    public RequestVO requestInsurances() {
        RequestVO requestVO = new RequestVO();
        println("모든 보험 상품들을 조회하시겠습니까? (Y/N)");
        requestVO.add(DesignConstant.READ_INSURANCE_RESULT, writeString());
        requestVO.add(ENTITY_LIST, ALL);
        requestVO.add(ENTITY_KIND, INSURANCE);
        return requestVO;
    }

    public void denyShowInsurances() {
        println("모든 보험 상품 조회를 거부하였습니다.");
    }

    public void showAllInsurance(ResponseVO responseVO) {
        println("모든 상품 정보를 나열합니다.");
        println("====================");
        for (int i = 0; i < 10; i++) {
            if (responseVO.get(String.valueOf(i)) == null) {
                break;
            }
            println(responseVO.get(String.valueOf(i)) + "\n");
        }
    }
}
