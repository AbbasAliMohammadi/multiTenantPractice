package com.example.multiTenantApp.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.multiTenantApp.domain.Tenant;
import com.example.multiTenantApp.repository.DataSourceRepository;
import com.example.multiTenantApp.repository.TenantRepository;

@Service
public class TenantService {
    private final TenantRepository tenantRepository;
    private final DataSourceRepository dataSourceRepository;

    public TenantService(TenantRepository tenantRepository, DataSourceRepository dataSourceRepository) {
        this.tenantRepository = tenantRepository;
        this.dataSourceRepository = dataSourceRepository;
    }

    @Transactional
    public boolean createTenant(Tenant tenant) {
        if (tenantRepository.existsBySchemaName(tenant.getSchemaName())) {
            throw new RuntimeException("Schema already exists");
        }

        // Create schema and tables
        dataSourceRepository.createSchema(tenant.getSchemaName());
        dataSourceRepository.createPostsTable(tenant.getSchemaName());

        return true;
    }
}