package com.slyvka.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ReservationEntityPK implements Serializable {
    private Integer id;
    private Integer tenantId;
    private Integer apartmentId;
    private Integer apartmentLandlordId;
    private String apartmentCityName;
    private String apartmentCountryName;
    private String apartmentStreetName;

    @Column(name = "id")
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "tenant_id")
    @Id
    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    @Column(name = "apartment_id")
    @Id
    public Integer getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Integer apartmentId) {
        this.apartmentId = apartmentId;
    }

    @Column(name = "apartment_landlord_id")
    @Id
    public Integer getApartmentLandlordId() {
        return apartmentLandlordId;
    }

    public void setApartmentLandlordId(Integer apartmentLandlordId) {
        this.apartmentLandlordId = apartmentLandlordId;
    }

    @Column(name = "apartment_city_name")
    @Id
    public String getApartmentCityName() {
        return apartmentCityName;
    }

    public void setApartmentCityName(String apartmentCityName) {
        this.apartmentCityName = apartmentCityName;
    }

    @Column(name = "apartment_country_name")
    @Id
    public String getApartmentCountryName() {
        return apartmentCountryName;
    }

    public void setApartmentCountryName(String apartmentCountryName) {
        this.apartmentCountryName = apartmentCountryName;
    }

    @Column(name = "apartment_street_name")
    @Id
    public String getApartmentStreetName() {
        return apartmentStreetName;
    }

    public void setApartmentStreetName(String apartmentStreetName) {
        this.apartmentStreetName = apartmentStreetName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationEntityPK that = (ReservationEntityPK) o;
        return Objects.equals(id, that.id) && Objects.equals(tenantId, that.tenantId) && Objects.equals(apartmentId, that.apartmentId) && Objects.equals(apartmentLandlordId, that.apartmentLandlordId) && Objects.equals(apartmentCityName, that.apartmentCityName) && Objects.equals(apartmentCountryName, that.apartmentCountryName) && Objects.equals(apartmentStreetName, that.apartmentStreetName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tenantId, apartmentId, apartmentLandlordId, apartmentCityName, apartmentCountryName, apartmentStreetName);
    }
}
