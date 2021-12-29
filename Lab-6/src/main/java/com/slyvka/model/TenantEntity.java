package com.slyvka.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tenant", schema = "Slyvka", catalog = "")
public class TenantEntity {
    private Integer id;
    private String name;
    private String surname;
    private BigDecimal moneyBalance;

    public TenantEntity() {

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "money_balance")
    public BigDecimal getMoneyBalance() {
        return moneyBalance;
    }

    public void setMoneyBalance(BigDecimal moneyBalance) {
        this.moneyBalance = moneyBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TenantEntity that = (TenantEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(moneyBalance, that.moneyBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, moneyBalance);
    }

    public TenantEntity(Integer id, String name, String surname, BigDecimal moneyBalance) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.moneyBalance = moneyBalance;
    }

    @Override
    public String toString() {
        return "TenantEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", moneyBalance=" + moneyBalance +
                '}';
    }
}
