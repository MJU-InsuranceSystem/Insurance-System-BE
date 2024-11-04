package fourservings_fiveservings.insurance_system_be.team.recruitment;

import fourservings_fiveservings.insurance_system_be.common.dto.RequestVO;
import fourservings_fiveservings.insurance_system_be.common.dto.ResponseVO;
import fourservings_fiveservings.insurance_system_be.team.Team;

/**
 * @author USER
 * @version 1.0
 */
public class RecruitmentTeam extends Team {

    public Applicant m_Applicant;
    public AppliCantListImpl m_AppliCantListImpl;

    public RecruitmentTeam() {

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
        return null;
    }

    @Override
    public ResponseVO remove(RequestVO request) {
        return null;
    }

    @Override
    public ResponseVO retrieve(RequestVO request) {
        return null;
    }
}