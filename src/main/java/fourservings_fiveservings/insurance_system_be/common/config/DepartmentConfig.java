package fourservings_fiveservings.insurance_system_be.common.config;

import fourservings_fiveservings.insurance_system_be.insurance.InsuranceList;
import fourservings_fiveservings.insurance_system_be.insurance.InsuranceListImpl;
import fourservings_fiveservings.insurance_system_be.insurance.apply.InsuranceApplyListImpl;
import fourservings_fiveservings.insurance_system_be.insurance.apply.InsuranceChargeCustomerApplyList;
import fourservings_fiveservings.insurance_system_be.insurance.apply.InsuranceChargeCustomerApplyListImpl;
import fourservings_fiveservings.insurance_system_be.insurance.company.InsuranceCompanyList;
import fourservings_fiveservings.insurance_system_be.team.TeamController;
import fourservings_fiveservings.insurance_system_be.team.TeamMethod;
import fourservings_fiveservings.insurance_system_be.team.contract.ContractListImpl;
import fourservings_fiveservings.insurance_system_be.team.contract.ContractManagementController;
import fourservings_fiveservings.insurance_system_be.team.contract.ContractManagementTeamMethod;
import fourservings_fiveservings.insurance_system_be.team.contract.ContractManagementView;
import fourservings_fiveservings.insurance_system_be.team.customerManagement.CustomerManageTeam;
import fourservings_fiveservings.insurance_system_be.team.customerManagement.controller.CustomerManagementController;
import fourservings_fiveservings.insurance_system_be.team.customerManagement.view.CustomerManagementView;
import fourservings_fiveservings.insurance_system_be.team.education.BusinessEducationTeamMethod;
import fourservings_fiveservings.insurance_system_be.team.education.controller.EducationController;
import fourservings_fiveservings.insurance_system_be.team.education.model.EducationListImpl;
import fourservings_fiveservings.insurance_system_be.team.education.view.EducationView;
import fourservings_fiveservings.insurance_system_be.team.plan.design.InsurancePlanTeamMethod;
import fourservings_fiveservings.insurance_system_be.team.plan.design.controller.InsurancePlanController;
import fourservings_fiveservings.insurance_system_be.team.plan.design.model.designPlan.DesignPlanList;
import fourservings_fiveservings.insurance_system_be.team.plan.design.model.designPlan.DesignPlanListImpl;
import fourservings_fiveservings.insurance_system_be.team.plan.design.model.proposal.ProposalList;
import fourservings_fiveservings.insurance_system_be.team.plan.design.model.proposal.ProposalListImpl;
import fourservings_fiveservings.insurance_system_be.team.plan.design.view.InsurancePlanView;
import fourservings_fiveservings.insurance_system_be.team.plan.inspection.InsuranceInspectionTeamMethod;
import fourservings_fiveservings.insurance_system_be.team.plan.inspection.InsuranceInspectionView;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.RewardSupportTeamMethod;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.controller.RewardSupportController;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.model.AccidentList;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.model.AccidentListImpl;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.model.InsurancePremiumPaymentCustomerList;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.model.InsurancePremiumPaymentCustomerListImpl;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.model.LitigationInfoList;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.model.LitigationInfoListImpl;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.view.RewardSupportView;
import fourservings_fiveservings.insurance_system_be.team.underwrite.UnderwriteTeamMethod;
import fourservings_fiveservings.insurance_system_be.team.underwrite.controller.UnderwriteController;
import fourservings_fiveservings.insurance_system_be.team.underwrite.model.UnderwritePolicyListImpl;
import fourservings_fiveservings.insurance_system_be.team.underwrite.view.UnderwriteView;
import fourservings_fiveservings.insurance_system_be.team.workerManagement.WorkerManagementTeamMethod;
import fourservings_fiveservings.insurance_system_be.team.workerManagement.controller.WorkerManagementController;
import fourservings_fiveservings.insurance_system_be.team.workerManagement.view.WorkerManagementView;

public class DepartmentConfig {

    public static EducationController educationController() {
        return new EducationController(educationView(), businessEducationTeam());
    }

    public static UnderwriteController underwriteController() {
        return new UnderwriteController(underwriteTeam(), underwriteView(),
                contractManagementTeam());
    }

    public static CustomerManagementController customerManagementController() {
        return new CustomerManagementController(customerManageTeam(), customerManagementView());
    }

    public static CustomerManageTeam customerManageTeam() {
        return new CustomerManageTeam();
    }

    public static CustomerManagementView customerManagementView() {
        return new CustomerManagementView();
    }

    public static WorkerManagementController workerManagementController() {
        return new WorkerManagementController(workerManagementTeam(), workerManagementView());
    }

    public static WorkerManagementTeamMethod workerManagementTeam() {
        return new WorkerManagementTeamMethod();
    }

    public static WorkerManagementView workerManagementView() {
        return new WorkerManagementView();
    }

    private static UnderwriteView underwriteView() {
        return new UnderwriteView();
    }

    private static UnderwriteTeamMethod underwriteTeam() {
        return new UnderwriteTeamMethod(new InsuranceCompanyList(), new InsuranceApplyListImpl(),
                new UnderwritePolicyListImpl());
    }

    private static ContractManagementTeamMethod contractManagementTeam() {
        return new ContractManagementTeamMethod(new ContractListImpl(),
                new InsuranceApplyListImpl());
    }

    private static EducationView educationView() {
        return new EducationView();
    }

    private static BusinessEducationTeamMethod businessEducationTeam() {
        return new BusinessEducationTeamMethod(new EducationListImpl());
    }

    public static TeamController designInspectionController() {
        return new InsurancePlanController(designTeamView(), insuranceInspectionTeamView(),
                designInspectionTeam(),
                insuranceInspectionTeam());
    }

    private static InsuranceInspectionView insuranceInspectionTeamView() {
        return new InsuranceInspectionView();
    }

    private static TeamMethod insuranceInspectionTeam() {
        return new InsuranceInspectionTeamMethod();
    }

    private static InsurancePlanView designTeamView() {
        return new InsurancePlanView();
    }

    private static InsurancePlanTeamMethod designInspectionTeam() {
        return new InsurancePlanTeamMethod(designPlanList(), proposalList(), insuranceList(),
                authrizationInsuranceList());
    }

    private static DesignPlanList designPlanList() {
        return new DesignPlanListImpl();
    }

    private static ProposalList proposalList() {
        return new ProposalListImpl();
    }

    private static InsuranceList insuranceList() {
        return new InsuranceListImpl();
    }

    private static InsuranceList authrizationInsuranceList() {
        return new InsuranceListImpl();
    }

    // reward
    public static RewardSupportController rewardSupportController() {
        return new RewardSupportController(rewardSupportView(), rewardSupportTeam(),
                new InsuranceChargeCustomerApplyListImpl());
    }

    private static RewardSupportView rewardSupportView() {
        return new RewardSupportView();
    }

    private static RewardSupportTeamMethod rewardSupportTeam() {
        return new RewardSupportTeamMethod(accidentList(), litigationInfoList(),
                insuranceChargeCustomerApplyList(), insurancePremiumPaymentCustomerList());
    }

    private static AccidentList accidentList() {
        return new AccidentListImpl();
    }

    private static LitigationInfoList litigationInfoList() {
        return new LitigationInfoListImpl();
    }

    private static InsuranceChargeCustomerApplyList insuranceChargeCustomerApplyList() {
        return new InsuranceChargeCustomerApplyListImpl();
    }

    private static InsurancePremiumPaymentCustomerList insurancePremiumPaymentCustomerList() {
        return new InsurancePremiumPaymentCustomerListImpl();
    }

    public static ContractManagementController contractManagementController() {
        return new ContractManagementController(contractManagementView(), contractManagementTeam());
    }

    public static ContractManagementView contractManagementView() {
        return new ContractManagementView();
    }
}
