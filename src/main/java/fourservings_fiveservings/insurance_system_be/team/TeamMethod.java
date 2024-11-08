package fourservings_fiveservings.insurance_system_be.team;


import fourservings_fiveservings.insurance_system_be.common.vo.RequestVO;
import fourservings_fiveservings.insurance_system_be.common.vo.ResponseVO;

/**
 * @author yoon
 * @version 1.0
 */
public abstract class TeamMethod {

    private int team_Id;
    private String team_name;

    public TeamMethod() {

    }

    public abstract ResponseVO manage(RequestVO request);

    public abstract ResponseVO process(RequestVO request);

    public abstract ResponseVO register(RequestVO request);

    public abstract ResponseVO remove(RequestVO request);

    public abstract ResponseVO retrieve(RequestVO request);


}