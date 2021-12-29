package com.slyvka.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "photo", schema = "Slyvka", catalog = "")
public class PhotoEntity {
    private Integer id;
    private String link;
    private ApartmentEntity apartment;

    public PhotoEntity(Integer id, String link, ApartmentEntity apartment) {
        this.id = id;
        this.link = link;
        this.apartment = apartment;
    }

    public PhotoEntity() {

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
    @Column(name = "link")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotoEntity that = (PhotoEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(link, that.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, link);
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "apartment_id", referencedColumnName = "id", nullable = false), @JoinColumn(name = "apartment_landlord_id", referencedColumnName = "landlord_id", nullable = false), @JoinColumn(name = "apartment_city_name", referencedColumnName = "city_name", nullable = false), @JoinColumn(name = "apartment_country_name", referencedColumnName = "country_name", nullable = false), @JoinColumn(name = "apartment_street_name", referencedColumnName = "street_name", nullable = false)})
    public ApartmentEntity getApartment() {
        return apartment;
    }

    public void setApartment(ApartmentEntity apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "PhotoEntity{" +
                "id=" + id +
                ", link='" + link + '\'' +
                ", apartment=" + apartment +
                '}';
    }
}
