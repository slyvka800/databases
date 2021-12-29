package com.slyvka.service;

import com.slyvka.DAO.MoneyTransferDaoImpl;
import com.slyvka.model.MoneyTransferEntity;

import java.sql.SQLException;
import java.util.List;

public class MoneyTransferService {
    public List<MoneyTransferEntity> findAll() throws SQLException {
        return new MoneyTransferDaoImpl().findAll();
    }

    public MoneyTransferEntity findById(Integer id, Integer landlordId, Integer tenantId) throws SQLException {
        return new MoneyTransferDaoImpl().findById(id, landlordId, tenantId);
    }

    public void create(MoneyTransferEntity entity) throws SQLException {
        new MoneyTransferDaoImpl().create(entity);
    }

    public MoneyTransferEntity update(MoneyTransferEntity entity) throws SQLException {
        return new MoneyTransferDaoImpl().update(entity);
    }

    public MoneyTransferEntity delete(Integer id, Integer landlordId, Integer tenantId) throws SQLException {
        return new MoneyTransferDaoImpl().delete(id, landlordId, tenantId);
    }
}
