package com.slyvka.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class ReservationEntity {
    private int id;
    private Date beginning_date;
    private Date ending_date;
    private boolean isArranged;
    private int tenantID;
    private int apartmentID;
    private int landlordID;
    private String city;
    private String country;
    private String street;


    public ReservationEntity(int id, Date beginning_date, Date ending_date, boolean isArranged, int tenantID,
                             int apartmentID, int landlordID, String city, String country, String street) {
        this.id = id;
        this.beginning_date = beginning_date;
        this.ending_date = ending_date;
        this.isArranged = isArranged;
        this.tenantID = tenantID;
        this.apartmentID = apartmentID;
        this.landlordID = landlordID;
        this.city = city;
        this.country = country;
        this.street = street;
    }

    @Override
    public String toString() {
        return "ReservationEntity{" +
                "id=" + id +
                ", beginning_date=" + beginning_date +
                ", ending_date=" + ending_date +
                ", isArrenged=" + isArranged +
                ", tenantID=" + tenantID +
                ", apartmentID=" + apartmentID +
                ", landlordID=" + landlordID +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}

