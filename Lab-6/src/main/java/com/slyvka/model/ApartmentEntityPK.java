package com.slyvka.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ApartmentEntityPK implements Serializable {
    private Integer id;
    private Integer landlordId;
    private String cityName;
    private String countryName;
    private String streetName;

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

    @Column(name = "city_name")
    @Id
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Column(name = "country_name")
    @Id
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Column(name = "street_name")
    @Id
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApartmentEntityPK that = (ApartmentEntityPK) o;
        return Objects.equals(id, that.id) && Objects.equals(landlordId, that.landlordId) && Objects.equals(cityName, that.cityName) && Objects.equals(countryName, that.countryName) && Objects.equals(streetName, that.streetName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, landlordId, cityName, countryName, streetName);
    }

    @Override
    public String toString() {
        return "ApartmentEntityPK{" +
                "id=" + id +
                ", landlordId=" + landlordId +
                ", cityName='" + cityName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", streetName='" + streetName + '\'' +
                '}';
    }
}
