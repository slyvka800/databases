package com.slyvka.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class MoneyTransferEntity {
    private int id;
    private Date time;
    private float money;
    private boolean isSent;
    private boolean isReceived;
    private boolean mayBeReceived;
    private int landlordID;
    private int tenantID;

    public MoneyTransferEntity(int id, Date time, float money, boolean isSent, boolean mayBeReceived, boolean isReceived,
                               int landlordID, int tenantID) {
        this.id = id;
        this.time = time;
        this.money = money;
        this.isSent = isSent;
        this.isReceived = isReceived;
        this.mayBeReceived = mayBeReceived;
        this.landlordID = landlordID;
        this.tenantID = tenantID;
    }

    @Override
    public String toString() {
        return "MoneyTransfer{" +
                "id=" + id +
                ", time=" + time +
                ", money=" + money +
                ", isSent=" + isSent +
                ", isReceived=" + isReceived +
                ", isMayBeReceived=" + mayBeReceived +
                ", landlordID=" + landlordID +
                ", tenantID=" + tenantID +
                '}';
    }
}

