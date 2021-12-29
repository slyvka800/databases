package com.slyvka.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "money_transfer", schema = "Slyvka", catalog = "")
@IdClass(MoneyTransferEntityPK.class)
public class MoneyTransferEntity {
    private Integer id;
    private Timestamp time;
    private BigDecimal money;
    private Byte isSent;
    private Byte mayBeRecieved;
    private Byte isRecieved;
    private Integer landlordId;
    private Integer tenantId;
    private LandlordEntity landlordByLandlordId;

    public MoneyTransferEntity(Integer id, Timestamp time, BigDecimal money, Byte isSent, Byte mayBeRecieved,
                               Byte isRecieved, Integer landlordId, Integer tenantId) {
        this.id = id;
        this.time = time;
        this.money = money;
        this.isSent = isSent;
        this.mayBeRecieved = mayBeRecieved;
        this.isRecieved = isRecieved;
        this.landlordId = landlordId;
        this.tenantId = tenantId;
    }

    public MoneyTransferEntity() {

    }

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "money")
    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Basic
    @Column(name = "is_sent")
    public Byte getIsSent() {
        return isSent;
    }

    public void setIsSent(Byte isSent) {
        this.isSent = isSent;
    }

    @Basic
    @Column(name = "may_be_recieved")
    public Byte getMayBeRecieved() {
        return mayBeRecieved;
    }

    public void setMayBeRecieved(Byte mayBeRecieved) {
        this.mayBeRecieved = mayBeRecieved;
    }

    @Basic
    @Column(name = "is_recieved")
    public Byte getIsRecieved() {
        return isRecieved;
    }

    public void setIsRecieved(Byte isRecieved) {
        this.isRecieved = isRecieved;
    }

    @Id
    @Column(name = "landlord_id")
    public Integer getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(Integer landlordId) {
        this.landlordId = landlordId;
    }

    @Id
    @Column(name = "tenant_id")
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
        MoneyTransferEntity that = (MoneyTransferEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(time, that.time) && Objects.equals(money, that.money) && Objects.equals(isSent, that.isSent) && Objects.equals(mayBeRecieved, that.mayBeRecieved) && Objects.equals(isRecieved, that.isRecieved) && Objects.equals(landlordId, that.landlordId) && Objects.equals(tenantId, that.tenantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, money, isSent, mayBeRecieved, isRecieved, landlordId, tenantId);
    }

    @ManyToOne
    @JoinColumn(name = "landlord_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public LandlordEntity getLandlordByLandlordId() {
        return landlordByLandlordId;
    }

    public void setLandlordByLandlordId(LandlordEntity landlordByLandlordId) {
        this.landlordByLandlordId = landlordByLandlordId;
    }

    @Override
    public String toString() {
        return "MoneyTransferEntity{" +
                "id=" + id +
                ", time=" + time +
                ", money=" + money +
                ", isSent=" + isSent +
                ", mayBeRecieved=" + mayBeRecieved +
                ", isRecieved=" + isRecieved +
                ", landlordId=" + landlordId +
                ", tenantId=" + tenantId +
                ", landlordByLandlordId=" + landlordByLandlordId +
                '}';
    }
}
