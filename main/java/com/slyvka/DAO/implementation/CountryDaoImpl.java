package com.slyvka.DAO.implementation;

import com.slyvka.DAO.GeneralDAO;
import com.slyvka.model.CityEntity;
import com.slyvka.model.CountryEntity;
import com.slyvka.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl implements GeneralDAO<CountryEntity, String> {
    private static final String FIND_ALL = "SELECT * FROM country";
    private static final String CREATE = "INSERT country (name) VALUES (?)";
    private static final String FIND_BY_ID = "SELECT * FROM country WHERE name=?";

    @Override
    public List<CountryEntity> findAll() throws SQLException {
        List<CountryEntity> entities = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(FIND_ALL)) {
                while(rs.next()) {
                    entities.add(new CountryEntity(
                            rs.getString("name")
                    ));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return entities;
    }

    @Override
    public CountryEntity findById(String name) throws SQLException {
        CountryEntity entity = null;
        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setString(1, name);
            try(ResultSet rs = statement.executeQuery()) {
                while(rs.next()){
                    entity = new CountryEntity(
                            rs.getString("name")
                    );
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return entity;
    }

    @Override
    public void create(CountryEntity entity) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, entity.getName());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public CountryEntity update(CountryEntity entity) throws SQLException {
        return null;
    }

    @Override
    public CountryEntity delete(String name) throws SQLException {
        return null;
    }
}
