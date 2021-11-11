package com.slyvka.DAO.implementation;

import com.slyvka.DAO.GeneralDAO;
import com.slyvka.DAO.TenantDAO;
import com.slyvka.model.TenantEntity;
import com.slyvka.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TenantDaoImpl implements TenantDAO {
    private static final String FIND_ALL = "SELECT * FROM tenant";
    private static final String DELETE = "DELETE FROM tenant WHERE id=?";
    private static final String CREATE = "INSERT tenant (id, name, surname, money_balance) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE tenant SET name=?, surname=?, money_balance=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM tenant WHERE id=?";
    private static final String FIND_BY_NAME = "SELECT * FROM tenant WHERE name=?";
    private static final String FIND_BY_SURNAME = "SELECT * FROM tenant WHERE surname=?";


    @Override
    public List<TenantEntity> findAll() throws SQLException {
        List<TenantEntity> entities = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(FIND_ALL)) {
                while(rs.next()) {
                    entities.add(new TenantEntity(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getFloat("money_balance"))
                    );
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return entities;
    }

    @Override
    public TenantEntity findById(Integer id) throws SQLException {
        TenantEntity entity = null;
        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try(ResultSet rs = statement.executeQuery()) {
                while(rs.next()){
                    entity = new TenantEntity(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getFloat("money_balance")
                    );
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return entity;
    }

    @Override
    public TenantEntity findByName(String name) throws SQLException {
        TenantEntity entity = null;
        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement statement = connection.prepareStatement(FIND_BY_NAME)) {
            statement.setString(1, name);
            try(ResultSet rs = statement.executeQuery()) {
                while(rs.next()){
                    entity = new TenantEntity(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getFloat("money_balance")
                    );
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return entity;
    }

    @Override
    public TenantEntity findBySurname(String surname) throws SQLException {
        TenantEntity entity = null;
        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement statement = connection.prepareStatement(FIND_BY_SURNAME)) {
            statement.setString(1, surname);
            try(ResultSet rs = statement.executeQuery()) {
                while(rs.next()){
                    entity = new TenantEntity(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getFloat("money_balance")
                    );
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return entity;
    }

    @Override
    public void create(TenantEntity entity) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getName());
            statement.setString(3, entity.getSurname());
            statement.setFloat(4, entity.getMoneyBalance());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public TenantEntity update(TenantEntity entity) throws SQLException {
        TenantEntity prevEntity = findById(entity.getId());

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getSurname());
            statement.setFloat(3, entity.getMoneyBalance());
            statement.setInt(4, entity.getId());
            statement.executeUpdate();
        }  catch (Exception e) {
            System.out.println(e);
        }

        return prevEntity;
    }

    @Override
    public TenantEntity delete(Integer id) throws SQLException {
        TenantEntity entity = findById(id);

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return entity;
    }
}
