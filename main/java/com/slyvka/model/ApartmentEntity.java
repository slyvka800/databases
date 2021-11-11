package com.slyvka.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class ApartmentEntity {
    private int id;
    private int area;
    private int numberOfRooms;
    private String feedback;
    private float rating;
    private int landlordID;
    private String city;
    private String country;
    private String street;


    public ApartmentEntity(int id, int area, int numberOfRooms, String feedback, float rating, int landlordID,
                           String city, String country, String street) {
        this.id = id;
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.feedback = feedback;
        this.rating = rating;
        this.landlordID = landlordID;
        this.city = city;
        this.country = country;
        this.street = street;
    }

    @Override
    public String toString() {
        return "ApartmentEntity{" +
                "id=" + id +
                ", area=" + area +
                ", numberOfRooms=" + numberOfRooms +
                ", feedback='" + feedback + '\'' +
                ", rating=" + rating +
                ", landlordID=" + landlordID +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}

