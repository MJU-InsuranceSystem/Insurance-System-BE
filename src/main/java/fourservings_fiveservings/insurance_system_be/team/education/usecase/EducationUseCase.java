package fourservings_fiveservings.insurance_system_be.team.education.usecase;


import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public enum EducationUseCase {

//    PREPARE_EDUCATION(1, "영업 교육을 준비한다.",
//        EducationView::prepareEducation, TeamMethod::register, EducationView::completeMessage),
//    MANAGE_EDUCATION(2, "영업 교육을 관리한다.",
//        EducationView::manageEducation, TeamMethod::process, EducationView::completeMessage),
//    MANAGE_EDUCATION_STUDENT(3, "교육대상자/수료생을 관리한다.",
//        EducationView::manageEducationStudent, TeamMethod::process, EducationView::completeMessage);
//
//    private final int order;
//    private final String description;
//
//    private final Function<EducationView, RequestVO> action;
//    private final BiFunction<TeamMethod, RequestVO, ResponseVO> teamAction;
//    private final BiConsumer<EducationView, ResponseVO> showResult;
//
//
//    EducationUseCase(int order, String description, Function<EducationView, RequestVO> action,
//        BiFunction<TeamMethod, RequestVO, ResponseVO> teamAction,
//        BiConsumer<EducationView, ResponseVO> showResult) {
//        this.order = order;
//        this.description = description;
//        this.action = action;
//        this.teamAction = teamAction;
//        this.showResult = showResult;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public int getOrder() {
//        return order;
//    }
//
//    public RequestVO viewAction(EducationView educationView) {
//        return action.apply(educationView);
//    }
//
//    public ResponseVO teamAction(TeamMethod teamMethod, RequestVO responseDto) {
//        return teamAction.apply(teamMethod, responseDto);
//    }
//
//    public void showResult(EducationView view, ResponseVO responseVO) {
//        this.showResult.accept(view, responseVO);
//    }
//
//    public static EducationUseCase findByNumber(int selectNumber) {
//        return Arrays.stream(EducationUseCase.values())
//            .filter(usecase -> usecase.getOrder() == selectNumber)
//            .findFirst()
//            .orElseThrow(() -> new IllegalArgumentException("해당 유스케이스 번호를 찾을 수 없습니다."));
//    }
}
