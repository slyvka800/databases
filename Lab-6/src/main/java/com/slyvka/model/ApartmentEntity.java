package com.slyvka.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "apartment", schema = "Slyvka", catalog = "")
@IdClass(ApartmentEntityPK.class)
public class ApartmentEntity {
    private Integer id;
    private Integer area;
    private Integer numberOfRoom;
    private String feedback;
    private BigDecimal rating;
    private Integer landlordId;
    private String cityName;
    private String countryName;
    private String streetName;

    public ApartmentEntity(Integer id, Integer area, Integer numberOfRoom, String feedback, BigDecimal rating,
                           Integer landlordId, String cityName, String countryName, String streetName) {
        this.id = id;
        this.area = area;
        this.numberOfRoom = numberOfRoom;
        this.feedback = feedback;
        this.rating = rating;
        this.landlordId = landlordId;
        this.cityName = cityName;
        this.countryName = countryName;
        this.streetName = streetName;
    }

    public ApartmentEntity() {
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
    @Column(name = "area")
    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    @Basic
    @Column(name = "number_of_room")
    public Integer getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(Integer numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    @Basic
    @Column(name = "feedback")
    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Basic
    @Column(name = "rating")
    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
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
    @Column(name = "city_name")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Id
    @Column(name = "country_name")
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Id
    @Column(name = "street_name")
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
        ApartmentEntity that = (ApartmentEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(area, that.area) && Objects.equals(numberOfRoom, that.numberOfRoom) && Objects.equals(feedback, that.feedback) && Objects.equals(rating, that.rating) && Objects.equals(landlordId, that.landlordId) && Objects.equals(cityName, that.cityName) && Objects.equals(countryName, that.countryName) && Objects.equals(streetName, that.streetName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, area, numberOfRoom, feedback, rating, landlordId, cityName, countryName, streetName);
    }

    @Override
    public String toString() {
        return "ApartmentEntity{" +
                "id=" + id +
                ", area=" + area +
                ", numberOfRoom=" + numberOfRoom +
                ", feedback='" + feedback + '\'' +
                ", rating=" + rating +
                ", landlordId=" + landlordId +
                ", cityName='" + cityName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", streetName='" + streetName + '\'' +
                '}';
    }
}
