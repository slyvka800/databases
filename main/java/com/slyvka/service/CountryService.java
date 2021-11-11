package com.slyvka.service;

import com.slyvka.DAO.implementation.CityDaoImpl;
import com.slyvka.DAO.implementation.CountryDaoImpl;
import com.slyvka.model.CityEntity;
import com.slyvka.model.CountryEntity;

import java.sql.SQLException;
import java.util.List;

public class CountryService {
    public List<CountryEntity> findAll() throws SQLException {
        return new CountryDaoImpl().findAll();
    }

    public CountryEntity findById(String name) throws SQLException {
        return new CountryDaoImpl().findById(name);
    }

    public void create(CountryEntity entity) throws SQLException {
        new CountryDaoImpl().create(entity);
    }
}
