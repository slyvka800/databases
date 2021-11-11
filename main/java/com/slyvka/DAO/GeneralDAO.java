package com.slyvka.DAO;

import com.slyvka.model.TenantEntity;

import java.sql.SQLException;
import java.util.List;

public interface GeneralDAO<T, ID> {
    List<T> findAll() throws SQLException;

    T findById(ID id) throws SQLException;

    void create(T entity) throws SQLException;

    T update(T entity) throws SQLException;

    T delete(ID id) throws SQLException;
}
