package com.example.multiTenantApp.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "tenants", schema = "public")

public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String schemaName;

    private boolean active = true;

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSchemaName() { return schemaName; }
    public void setSchemaName(String schemaName) { this.schemaName = schemaName; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}