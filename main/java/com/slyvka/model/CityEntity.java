package com.slyvka.model;

import com.slyvka.DAO.GeneralDAO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityEntity{
    private String name;

    public CityEntity(String name) {
        this.name = name;
    }

    public CityEntity() {
        this(null);
    }


    @Override
    public String toString() {
        return "CityEntity{" +
                " name='" + name + '\'' +
                '}';
    }
}
