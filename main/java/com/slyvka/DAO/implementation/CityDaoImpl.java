package com.slyvka.DAO.implementation;

import com.slyvka.DAO.GeneralDAO;
import com.slyvka.model.CityEntity;
import com.slyvka.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl implements GeneralDAO<CityEntity, String> {
    private static final String FIND_ALL = "SELECT * FROM city";
    private static final String CREATE = "INSERT city (name) VALUES (?)";
    private static final String FIND_BY_ID = "SELECT * FROM city WHERE name=?";

    @Override
    public List<CityEntity> findAll() throws SQLException {
        List<CityEntity> entities = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(FIND_ALL)) {
                while(rs.next()) {
                    entities.add(new CityEntity(
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
    public CityEntity findById(String name) throws SQLException {
        CityEntity entity = null;
        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setString(1, name);
            try(ResultSet rs = statement.executeQuery()) {
                while(rs.next()){
                    entity = new CityEntity(
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
    public void create(CityEntity entity) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, entity.getName());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public CityEntity update(CityEntity entity) throws SQLException {
        return null;
    }

    @Override
    public CityEntity delete(String name) throws SQLException {
        return null;
    }
}
