package com.slyvka.service;

import com.slyvka.DAO.LandlordDaoImpl;
import com.slyvka.model.LandlordEntity;

import java.sql.SQLException;
import java.util.List;

public class LandlordService {
    public List<LandlordEntity> findAll() throws SQLException {
        return new LandlordDaoImpl().findAll();
    }

    public LandlordEntity findById(Integer id) throws SQLException {
        return new LandlordDaoImpl().findById(id);
    }

    public void create(LandlordEntity entity) throws SQLException {
        new LandlordDaoImpl().create(entity);
    }

    public LandlordEntity update(LandlordEntity entity) throws SQLException {
        return new LandlordDaoImpl().update(entity);
    }

    public LandlordEntity delete(Integer id) throws SQLException {
        return new LandlordDaoImpl().delete(id);
    }
}
