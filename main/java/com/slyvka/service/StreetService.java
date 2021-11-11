package com.slyvka.service;

import com.slyvka.DAO.implementation.CityDaoImpl;
import com.slyvka.DAO.implementation.StreetDaoImpl;
import com.slyvka.model.CityEntity;
import com.slyvka.model.StreetEntity;

import java.sql.SQLException;
import java.util.List;

public class StreetService {
    public List<StreetEntity> findAll() throws SQLException {
        return new StreetDaoImpl().findAll();
    }

    public StreetEntity findById(String name) throws SQLException {
        return new StreetDaoImpl().findById(name);
    }

    public void create(StreetEntity entity) throws SQLException {
        new StreetDaoImpl().create(entity);
    }
}
