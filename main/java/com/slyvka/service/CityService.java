package com.slyvka.service;

import com.slyvka.DAO.implementation.CityDaoImpl;
import com.slyvka.DAO.implementation.TenantDaoImpl;
import com.slyvka.model.CityEntity;
import com.slyvka.model.TenantEntity;

import java.sql.SQLException;
import java.util.List;

public class CityService {
    public List<CityEntity> findAll() throws SQLException {
        return new CityDaoImpl().findAll();
    }

    public CityEntity findById(String name) throws SQLException {
        return new CityDaoImpl().findById(name);
    }

    public void create(CityEntity entity) throws SQLException {
        new CityDaoImpl().create(entity);
    }
}
