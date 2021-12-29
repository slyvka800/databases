package com.slyvka.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MoneyTransferEntityPK implements Serializable {
    private Integer id;
    private Integer landlordId;

    public MoneyTransferEntityPK(Integer id, Integer landlordId, Integer tenantId) {
        this.id = id;
        this.landlordId = landlordId;
        this.tenantId = tenantId;
    }

    public MoneyTransferEntityPK() {
    }

    private Integer tenantId;

    @Column(name = "id")
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "landlord_id")
    @Id
    public Integer getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(Integer landlordId) {
        this.landlordId = landlordId;
    }

    @Column(name = "tenant_id")
    @Id
    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoneyTransferEntityPK that = (MoneyTransferEntityPK) o;
        return Objects.equals(id, that.id) && Objects.equals(landlordId, that.landlordId) && Objects.equals(tenantId, that.tenantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, landlordId, tenantId);
    }
}
