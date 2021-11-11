package com.slyvka.DAO.implementation;

import com.slyvka.DAO.GeneralDAO;
import com.slyvka.model.MoneyTransferEntity;
import com.slyvka.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MoneyTransferDaoImpl implements GeneralDAO<MoneyTransferEntity, Integer> {
    private static final String FIND_ALL = "SELECT * FROM money_transfer";
    private static final String DELETE = "DELETE FROM money_transfer WHERE id=?";
    private static final String CREATE = "INSERT money_transfer (id, time, money, is_sent, may_be_recieved, is_recieved," +
            " landlord_id, tenant_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE money_transfer SET time=?, money=?, is_sent=?, may_be_recieved=?, " +
            "is_recieved=?, landlord_id=?, tenant_id=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM money_transfer WHERE id=?";

    @Override
    public List<MoneyTransferEntity> findAll() throws SQLException {
        List<MoneyTransferEntity> entities = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(FIND_ALL)) {
                while(rs.next()) {
                    entities.add(new MoneyTransferEntity(
                            rs.getInt("id"),
                            rs.getDate("time"),
                            rs.getFloat("money"),
                            rs.getBoolean("is_sent"),
                            rs.getBoolean("may_be_recieved"),
                            rs.getBoolean("is_recieved"),
                            rs.getInt("landlord_id"),
                            rs.getInt("tenant_id"))
                    );
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return entities;
    }

    @Override
    public MoneyTransferEntity findById(Integer id) throws SQLException {
        MoneyTransferEntity entity = null;
        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try(ResultSet rs = statement.executeQuery()) {
                while(rs.next()){
                    entity = new MoneyTransferEntity(
                            rs.getInt("id"),
                            rs.getDate("time"),
                            rs.getFloat("money"),
                            rs.getBoolean("is_sent"),
                            rs.getBoolean("may_be_recieved"),
                            rs.getBoolean("is_recieved"),
                            rs.getInt("landlord_id"),
                            rs.getInt("tenant_id")
                    );
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return entity;
    }

    @Override
    public void create(MoneyTransferEntity entity) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1,entity.getId());
            statement.setDate(2, entity.getTime());
            statement.setFloat(3, entity.getMoney());
            statement.setBoolean(4, entity.isSent());
            statement.setBoolean(5, entity.isMayBeReceived());
            statement.setBoolean(6, entity.isReceived());
            statement.setInt(7, entity.getLandlordID());
            statement.setInt(8, entity.getTenantID());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public MoneyTransferEntity update(MoneyTransferEntity entity) throws SQLException {
        MoneyTransferEntity prevEntity = findById(entity.getId());

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1,entity.getId());
            statement.setDate(2, entity.getTime());
            statement.setFloat(3, entity.getMoney());
            statement.setBoolean(4, entity.isSent());
            statement.setBoolean(5, entity.isMayBeReceived());
            statement.setBoolean(6, entity.isReceived());
            statement.setInt(7, entity.getLandlordID());
            statement.setInt(8, entity.getTenantID());
            statement.executeUpdate();
        }  catch (Exception e) {
            System.out.println(e);
        }

        return prevEntity;
    }

    @Override
    public MoneyTransferEntity delete(Integer id) throws SQLException {
        MoneyTransferEntity entity = findById(id);

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return entity;
    }
}
