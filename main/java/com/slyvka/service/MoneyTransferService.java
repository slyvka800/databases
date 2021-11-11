package com.slyvka.service;

import com.slyvka.DAO.implementation.MoneyTransferDaoImpl;
import com.slyvka.DAO.implementation.TenantDaoImpl;
import com.slyvka.model.MoneyTransferEntity;
import com.slyvka.model.TenantEntity;

import java.sql.SQLException;
import java.util.List;

public class MoneyTransferService {
    public List<MoneyTransferEntity> findAll() throws SQLException {
        return new MoneyTransferDaoImpl().findAll();
    }

    public MoneyTransferEntity findById(Integer id) throws SQLException {
        return new MoneyTransferDaoImpl().findById(id);
    }

    public void create(MoneyTransferEntity entity) throws SQLException {
        new MoneyTransferDaoImpl().create(entity);
    }

    public MoneyTransferEntity update(MoneyTransferEntity entity) throws SQLException {
        return new MoneyTransferDaoImpl().update(entity);
    }

    public MoneyTransferEntity delete(Integer id) throws SQLException {
        return new MoneyTransferDaoImpl().delete(id);
    }
}
