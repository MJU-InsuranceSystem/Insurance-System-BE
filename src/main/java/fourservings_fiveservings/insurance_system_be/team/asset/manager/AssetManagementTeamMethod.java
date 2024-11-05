package fourservings_fiveservings.insurance_system_be.team.asset.manager;


import fourservings_fiveservings.insurance_system_be.common.dto.RequestVO;
import fourservings_fiveservings.insurance_system_be.common.dto.ResponseVO;
import fourservings_fiveservings.insurance_system_be.team.TeamMethod;
import fourservings_fiveservings.insurance_system_be.team.asset.InvestScenario;
import fourservings_fiveservings.insurance_system_be.team.asset.InvestScenarioListImpl;
import fourservings_fiveservings.insurance_system_be.team.asset.LoanHistoryListImpl;

public class AssetManagementTeamMethod extends TeamMethod {

    public InvestScenario m_InvestScenario;
    public InvestScenarioListImpl m_InvestScenarioListImpl;
    public LoanHistoryListImpl m_LoanHistoryListImpl;

    public AssetManagementTeamMethod() {

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
        super.finalize();
    }

    public void createStatistic() {

    }

    public Object readLoanHistory() {
        return null;
    }

    public void readStatisticHistory() {

    }

    public void saveSimulationResult() {

    }

}