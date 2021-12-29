package com.slyvka.service;

import com.slyvka.DAO.TenantDaoImpl;
import com.slyvka.model.TenantEntity;

import java.sql.SQLException;
import java.util.List;

public class TenantService {
    public List<TenantEntity> findAll() throws SQLException {
        return new TenantDaoImpl().findAll();
    }

    public TenantEntity findById(Integer id) throws SQLException {
        return new TenantDaoImpl().findById(id);
    }

    public TenantEntity findByName(String name) throws SQLException {
        return new TenantDaoImpl().findByName(name);
    }

    public TenantEntity findBySurname(String surname) throws SQLException {
        return new TenantDaoImpl().findBySurname(surname);
    }

    public void create(TenantEntity entity) throws SQLException {
        new TenantDaoImpl().create(entity);
    }

    public TenantEntity update(TenantEntity entity) throws SQLException {
        return new TenantDaoImpl().update(entity);
    }

    public TenantEntity delete(Integer id) throws SQLException {
        return new TenantDaoImpl().delete(id);
    }
}
