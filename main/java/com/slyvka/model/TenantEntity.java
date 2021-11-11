package com.slyvka.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TenantEntity {
    private Integer id;
    private String name;
    private String surname;
    private Float moneyBalance;


    public TenantEntity(Integer id, String name, String surname, Float moneyBalance) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.moneyBalance = moneyBalance;
    }

    public TenantEntity(String name, String surname, Float moneyBalance) {
        this(null, name, surname, moneyBalance);
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

