package fourservings_fiveservings.insurance_system_be.team.contract;


import fourservings_fiveservings.insurance_system_be.common.dto.RequestVO;
import fourservings_fiveservings.insurance_system_be.common.view.DepartmentView;

public class ContractManagementView extends DepartmentView {

    public static final String CONTRACT_ID = "contractId";

    public void retrieveContracts(ContractList contractList) {
        if (contractList.isEmpty()) {
            println("계약이 존재하지 않습니다.");
            return;
        }
        contractList.getContracts().stream()
            .map(Contract::toString)
            .forEach(System.out::println);
        successTask();
    }

    public RequestVO requireDeleteContractNumber() {
        RequestVO requestVO = new RequestVO();
        print("파기할 계약 번호 : ");
        requestVO.add(CONTRACT_ID, writeString());
        return requestVO;
    }

    public void successTask() {
        println("업무 수행을 완료하였습니다.");
    }
}
