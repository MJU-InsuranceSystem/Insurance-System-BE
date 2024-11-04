package fourservings_fiveservings.insurance_system_be.team.marketing;


import fourservings_fiveservings.insurance_system_be.common.dto.RequestVO;
import fourservings_fiveservings.insurance_system_be.common.dto.ResponseVO;
import fourservings_fiveservings.insurance_system_be.team.Team;

/**
 * @author USER
 * @version 1.0
 */
public class MarketingTeam extends Team {

    public Campaign campaign;
    public CampaignListImpl campaignListImpl;

    public MarketingTeam() {

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