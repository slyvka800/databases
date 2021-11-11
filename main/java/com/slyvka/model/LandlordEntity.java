package com.slyvka.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LandlordEntity {
    private Integer id;
    private String name;
    private String surname;
    private Float moneyBalance;


    public LandlordEntity(Integer id, String name, String surname, Float moneyBalance) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.moneyBalance = moneyBalance;
    }

    public LandlordEntity(String name, String surname, Float moneyBalance) {
        this(null, name, surname, moneyBalance);
    }


    @Override
    public String toString() {
        return "LandlordEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", moneyBalance=" + moneyBalance +
                '}';
    }
}
