package com.slyvka.DAO.Interfaces;

import com.slyvka.model.MoneyTransferEntity;

import java.sql.SQLException;
import java.util.List;

public interface MoneyTransferDao {
    List<MoneyTransferEntity> findAll() throws SQLException;

    MoneyTransferEntity findById(Integer id, Integer landlordId, Integer tenantId) throws SQLException;

    void create(MoneyTransferEntity entity) throws SQLException;

    MoneyTransferEntity update(MoneyTransferEntity entity) throws SQLException;

    MoneyTransferEntity delete(Integer id, Integer landlordId, Integer tenantId) throws SQLException;
}
