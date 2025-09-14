package com.example.multiTenantApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.multiTenantApp.domain.TenantWithSameTable;

public interface TenantWithSameTableRepository extends JpaRepository<TenantWithSameTable, Long>{

}
