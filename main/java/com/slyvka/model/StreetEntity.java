package com.slyvka.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StreetEntity {
    private String name;

    public StreetEntity(String name) {
        this.name = name;
    }

    public StreetEntity() {
        this(null);
    }


    @Override
    public String toString() {
        return "StreetEntity{" +
                " name='" + name + '\'' +
                '}';
    }
}
