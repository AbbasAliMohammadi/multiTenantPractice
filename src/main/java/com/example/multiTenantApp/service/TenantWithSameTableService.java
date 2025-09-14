package com.example.multiTenantApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.multiTenantApp.domain.TenantWithSameTable;
import com.example.multiTenantApp.repository.TenantWithSameTableRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TenantWithSameTableService {
    private final TenantWithSameTableRepository tenantWithSameTableRepository;

    public List<TenantWithSameTable> findAll() {
        return tenantWithSameTableRepository.findAll();
    }

    public TenantWithSameTable save(TenantWithSameTable tenantWithSameTable) {
        return tenantWithSameTableRepository.save(tenantWithSameTable);
    }
}
