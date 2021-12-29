package com.slyvka.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "reservation", schema = "Slyvka", catalog = "")
@IdClass(ReservationEntityPK.class)
public class ReservationEntity {
    private Integer id;
    private Date beginningDate;
    private Date endingDate;
    private Byte isArranged;
    private Integer tenantId;
    private Integer apartmentId;
    private Integer apartmentLandlordId;
    private String apartmentCityName;
    private String apartmentCountryName;
    private String apartmentStreetName;
    private ApartmentEntity apartment;

    public ReservationEntity(Integer id, Date beginningDate, Date endingDate, Byte isArranged, Integer tenantId,
                             Integer apartmentId, Integer apartmentLandlordId, String apartmentCityName,
                             String apartmentCountryName, String apartmentStreetName, ApartmentEntity apartment) {
        this.id = id;
        this.beginningDate = beginningDate;
        this.endingDate = endingDate;
        this.isArranged = isArranged;
        this.tenantId = tenantId;
        this.apartmentId = apartmentId;
        this.apartmentLandlordId = apartmentLandlordId;
        this.apartmentCityName = apartmentCityName;
        this.apartmentCountryName = apartmentCountryName;
        this.apartmentStreetName = apartmentStreetName;
        this.apartment = apartment;
    }

    public ReservationEntity() {

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
    @Column(name = "beginning_date")
    public Date getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(Date beginningDate) {
        this.beginningDate = beginningDate;
    }

    @Basic
    @Column(name = "ending_date")
    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    @Basic
    @Column(name = "is_arranged")
    public Byte getIsArranged() {
        return isArranged;
    }

    public void setIsArranged(Byte isArranged) {
        this.isArranged = isArranged;
    }

    @Id
    @Column(name = "tenant_id")
    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    @Id
    @Column(name = "apartment_id")
    public Integer getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Integer apartmentId) {
        this.apartmentId = apartmentId;
    }

    @Id
    @Column(name = "apartment_landlord_id")
    public Integer getApartmentLandlordId() {
        return apartmentLandlordId;
    }

    public void setApartmentLandlordId(Integer apartmentLandlordId) {
        this.apartmentLandlordId = apartmentLandlordId;
    }

    @Id
    @Column(name = "apartment_city_name")
    public String getApartmentCityName() {
        return apartmentCityName;
    }

    public void setApartmentCityName(String apartmentCityName) {
        this.apartmentCityName = apartmentCityName;
    }

    @Id
    @Column(name = "apartment_country_name")
    public String getApartmentCountryName() {
        return apartmentCountryName;
    }

    public void setApartmentCountryName(String apartmentCountryName) {
        this.apartmentCountryName = apartmentCountryName;
    }

    @Id
    @Column(name = "apartment_street_name")
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
        ReservationEntity that = (ReservationEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(beginningDate, that.beginningDate) && Objects.equals(endingDate, that.endingDate) && Objects.equals(isArranged, that.isArranged) && Objects.equals(tenantId, that.tenantId) && Objects.equals(apartmentId, that.apartmentId) && Objects.equals(apartmentLandlordId, that.apartmentLandlordId) && Objects.equals(apartmentCityName, that.apartmentCityName) && Objects.equals(apartmentCountryName, that.apartmentCountryName) && Objects.equals(apartmentStreetName, that.apartmentStreetName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, beginningDate, endingDate, isArranged, tenantId, apartmentId, apartmentLandlordId, apartmentCityName, apartmentCountryName, apartmentStreetName);
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "apartment_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "apartment_landlord_id", referencedColumnName = "landlord_id", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "apartment_city_name", referencedColumnName = "city_name", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "apartment_country_name", referencedColumnName = "country_name", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "apartment_street_name", referencedColumnName = "street_name", nullable = false, insertable = false, updatable = false)})
    public ApartmentEntity getApartment() {
        return apartment;
    }

    public void setApartment(ApartmentEntity apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "ReservationEntity{" +
                "id=" + id +
                ", beginningDate=" + beginningDate +
                ", endingDate=" + endingDate +
                ", isArranged=" + isArranged +
                ", tenantId=" + tenantId +
                ", apartmentId=" + apartmentId +
                ", apartmentLandlordId=" + apartmentLandlordId +
                ", apartmentCityName='" + apartmentCityName + '\'' +
                ", apartmentCountryName='" + apartmentCountryName + '\'' +
                ", apartmentStreetName='" + apartmentStreetName + '\'' +
                ", apartment=" + apartment +
                '}';
    }
}
