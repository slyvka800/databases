package com.slyvka.DAO.implementation;

import com.slyvka.DAO.GeneralDAO;
import com.slyvka.model.CityEntity;
import com.slyvka.model.StreetEntity;
import com.slyvka.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StreetDaoImpl implements GeneralDAO<StreetEntity, String> {
    private static final String FIND_ALL = "SELECT * FROM street";
    private static final String CREATE = "INSERT street (name) VALUES (?)";
    private static final String FIND_BY_ID = "SELECT * FROM street WHERE name=?";

    @Override
    public List<StreetEntity> findAll() throws SQLException {
        List<StreetEntity> entities = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(FIND_ALL)) {
                while(rs.next()) {
                    entities.add(new StreetEntity(
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
    public StreetEntity findById(String name) throws SQLException {
        StreetEntity entity = null;
        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setString(1, name);
            try(ResultSet rs = statement.executeQuery()) {
                while(rs.next()){
                    entity = new StreetEntity(
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
    public void create(StreetEntity entity) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, entity.getName());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public StreetEntity update(StreetEntity entity) throws SQLException {
        return null;
    }

    @Override
    public StreetEntity delete(String name) throws SQLException {
        return null;
    }
}
