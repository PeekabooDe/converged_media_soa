package com.idianyou.media.core.filter;

import com.idianyou.media.core.common.DataSourceUtils;
import com.idianyou.media.core.entity.MasterTenant;
import com.idianyou.media.core.repository.MasteTenantRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
@Configuration
public class DataSourceBasedMultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

    @Autowired
    private MasteTenantRepository masteTenantRepository;

    private Map<String, DataSource> dataSources = new TreeMap<String, DataSource>();

    @Override
    protected DataSource selectAnyDataSource() {
        if(dataSources.isEmpty()) {
            final List<MasterTenant> tenants = masteTenantRepository.findAll();
            tenants.forEach(masterTenant -> {
                dataSources.put(masterTenant.getTenant(), DataSourceUtils.wrapperDataSource(masterTenant));
            });
        }
        return dataSources.values().iterator().next();
    }

    @Override
    protected DataSource selectDataSource(String tenant) {
        if(!dataSources.containsKey(tenant)) {
            List<MasterTenant> tenants = masteTenantRepository.findAll();
            tenants.forEach(masterTenant -> {
                dataSources.put(masterTenant.getTenant(), DataSourceUtils.wrapperDataSource(masterTenant));
            });
        }
        return dataSources.get(tenant);
    }
}
