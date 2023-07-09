package wanted;

public class ReplicationRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        DataSourceType dataSourceType = TransactionSynchronizationManager
                .isCurrentTransactionReadOnly() ? DataSourceType.Slave : DataSourceType.Master;

        return dataSourceType;
    }
}