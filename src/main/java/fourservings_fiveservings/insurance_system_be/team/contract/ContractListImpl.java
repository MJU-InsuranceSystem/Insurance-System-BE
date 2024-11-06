package fourservings_fiveservings.insurance_system_be.team.contract;

import fourservings_fiveservings.insurance_system_be.insurance.apply.InsuranceApplication;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 */
public class ContractListImpl implements ContractList {

    private static final List<Contract> CONTRACTS = new ArrayList<>();

    @Override
    public void add(Contract contract) {
        CONTRACTS.add(contract);
    }

    @Override
    public void remove(Contract contract) {
        CONTRACTS.remove(contract);
    }

    @Override
    public void removeById(int contractId) {
        CONTRACTS.removeIf(contract -> contract.getId() == contractId);
    }

    @Override
    public InsuranceApplication findById(int contractId) {
        for (Contract contract : CONTRACTS) {
            if (contract.getId() == contractId) {
                return contract.getInsuranceApplication();
            }
        }
        return null;
    }

    @Override
    public List<Contract> getContracts() {
        return new ArrayList<>(CONTRACTS);
    }

    @Override
    public void update(Contract contract) {
        for (int i = 0; i < CONTRACTS.size(); i++) {
            if (CONTRACTS.get(i).getId() == contract.getId()) {
                CONTRACTS.set(i, contract);
                return;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return CONTRACTS.isEmpty();
    }
}