package fourservings_fiveservings.insurance_system_be.common.config;

import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
public class RoutingDataSourceConfig extends AbstractRoutingDataSource {

    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        String lookupKey =
            TransactionSynchronizationManager.isCurrentTransactionReadOnly() ? "replica" : "master";
        log.info("Current DataSource is {}", lookupKey);
        return lookupKey;
    }
}