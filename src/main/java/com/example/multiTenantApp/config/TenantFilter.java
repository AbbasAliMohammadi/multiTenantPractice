package com.example.multiTenantApp.config;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TenantFilter extends OncePerRequestFilter {
    private final TenantIdentifierResolver tenantIdentifierResolver;
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            String tenant = request.getHeader("X-Tenant-ID");
            tenantIdentifierResolver.setCurrentTenant(tenant != null ? tenant : "public");
            filterChain.doFilter(request, response);
        } finally {
        }
    }
}

