package com.slyvka.DAO.Interfaces;

import com.slyvka.model.TenantEntity;

import java.sql.SQLException;

public interface TenantDAO extends GeneralDAO<TenantEntity, Integer> {
    TenantEntity findByName(String name) throws SQLException;
    TenantEntity findBySurname(String surname) throws SQLException;
}