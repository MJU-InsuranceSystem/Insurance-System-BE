package fourservings_fiveservings.insurance_system_be.team.education.view;


import fourservings_fiveservings.insurance_system_be.common.dto.RequestVO;
import fourservings_fiveservings.insurance_system_be.common.dto.ResponseVO;
import fourservings_fiveservings.insurance_system_be.common.view.DepartmentView;
import fourservings_fiveservings.insurance_system_be.team.plan.Status;

public class EducationView extends DepartmentView {

    public static final String EDUCATION_SCHEDULE = "schedule";
    public static final String EDUCATION_NAME = "name";
    public static final String EDUCATION_LOCATION = "location";
    public static final String EDUCATION_TEACHER = "teacher";
    public static final String EDUCATION_CONTENTS = "contents";
    public static final String EDUCATION_TEXTBOOK = "textbook";
    public static final String MANAGE_RESPONSE_RESULT = "manageResponseReuslt";
    public static final String ALL_EDUCATION = "alleducation";

    public void intro() {
        println("안녕하세요. 영업 교육팀입니다.");
    }

    public void completeMessage(ResponseVO responseVO) {
        println("성공적으로 업무를 완료하였습니다");
        println("상태 메시지 : " + responseVO.get(Status.getKey()));
    }

    public RequestVO manageEducation() {
        RequestVO requestVO = new RequestVO();
        println("현재 만들어진 모든 교육을 조회하겠습니까? (Y/N)");
        requestVO.add(MANAGE_RESPONSE_RESULT, writeString());
        return requestVO;
    }

    public RequestVO prepareEducation() {
        RequestVO requestVO = new RequestVO();
        println("교육을 추가하기 전 정보를 입력해주세요");
        print("교육 이름 :");
        requestVO.add(EDUCATION_NAME, writeString());
        print("교육 장소 :");
        requestVO.add(EDUCATION_LOCATION, writeString());
        print("교육 일자 :");
        requestVO.add(EDUCATION_SCHEDULE, writeString());
        print("교육 내용 :");
        requestVO.add(EDUCATION_CONTENTS, writeString());
        print("강사 이름 :");
        requestVO.add(EDUCATION_TEACHER, writeString());
        print("교재 이름 :");
        requestVO.add(EDUCATION_TEXTBOOK, writeString());
        return requestVO;
    }

    public RequestVO manageEducationStudent() {
        return null;
    }

    public void deny() {
        println("해당 업무가 거절되었습니다.");
    }

    public void showAllEducationName(ResponseVO responseVO) {
        println("모든 교육 제목");
        println("================");
        println(responseVO.get(ALL_EDUCATION));
    }
}
