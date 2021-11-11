package com.slyvka.DAO.implementation;

import com.slyvka.DAO.GeneralDAO;
import com.slyvka.model.ApartmentEntity;
import com.slyvka.model.MoneyTransferEntity;
import com.slyvka.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApartmentDaoImpl implements GeneralDAO<ApartmentEntity, Integer> {
    private static final String FIND_ALL = "SELECT * FROM money_transfer";
    private static final String DELETE = "DELETE FROM money_transfer WHERE id=?";
    private static final String CREATE = "INSERT money_transfer (id, beginning_date, ending_date, is_arranged, " +
            "tenant_id, apartment_id, apartment_landlord_id, apartment_city_name, apartment_country_name, " +
            "apartment_street_name) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE money_transfer SET beginning_date=?, ending_date=?, is_arranged=?, " +
            "tenant_id=?, apartment_id=?, apartment_landlord_id=?, apartment_city_name=?, apartment_country_name=?, " +
            "apartment_street_name=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM money_transfer WHERE id=?";

    @Override
    public List<ApartmentEntity> findAll() throws SQLException {
        List<ApartmentEntity> entities = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(FIND_ALL)) {
                while(rs.next()) {
                    entities.add(new ApartmentEntity(
                            rs.getInt("id"),
                            rs.getDate("beginning_date"),
                            rs.getDate("ending_date"),
                            rs.getBoolean("is_arranged"),
                            rs.getInt("tenant_id"),
                            rs.getInt("apartment_id"),
                            rs.getInt("apartment_landlord_id"),
                            rs.getString("apartment_city_name"),
                            rs.getString("apartment_country_name"),
                            rs.getString("apartment_street_name")
                            )
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
