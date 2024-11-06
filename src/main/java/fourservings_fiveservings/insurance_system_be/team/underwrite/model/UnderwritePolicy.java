package fourservings_fiveservings.insurance_system_be.team.underwrite.model;

import fourservings_fiveservings.insurance_system_be.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Setter;

/**
 * @author yoon
 * @version 1.0
 */

@Entity
@Setter
public class UnderwritePolicy extends BaseEntity {

    @Id
    private Long policyId;
    private String policyType;
    private String policyName;
    private String riskInfo;
    private String premiumInfo;
    private String subscriptionInfo;


    public String getPolicyName() {
        return policyName;
    }

    public String getRiskInfo() {
        return riskInfo;
    }

    public String getPremiumInfo() {
        return premiumInfo;
    }

    public String getSubscriptionInfo() {
        return subscriptionInfo;
    }

    
}