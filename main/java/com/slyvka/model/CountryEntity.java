package com.slyvka.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryEntity {
    private String name;

    public CountryEntity(String name) {
        this.name = name;
    }

    public CountryEntity() {
        this(null);
    }


    @Override
    public String toString() {
        return "CountryEntity{" +
                " name='" + name + '\'' +
                '}';
    }
}
