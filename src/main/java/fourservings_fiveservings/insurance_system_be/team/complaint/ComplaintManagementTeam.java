package fourservings_fiveservings.insurance_system_be.team.complaint;


import fourservings_fiveservings.insurance_system_be.common.dto.RequestVO;
import fourservings_fiveservings.insurance_system_be.common.dto.ResponseVO;
import fourservings_fiveservings.insurance_system_be.team.Team;
import fourservings_fiveservings.insurance_system_be.team.complaint.model.Complaint;
import fourservings_fiveservings.insurance_system_be.team.complaint.model.ComplaintList;
import fourservings_fiveservings.insurance_system_be.team.complaint.model.ComplaintListImpl;

/**
 * @author USER
 * @version 1.0
 */
public class ComplaintManagementTeam extends Team {

    public Complaint complaint;

    private final ComplaintList complaintList = new ComplaintListImpl();

    public ComplaintManagementTeam() {

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

    public void finalize() throws Throwable {

    }

    public void analyze() {

    }

}