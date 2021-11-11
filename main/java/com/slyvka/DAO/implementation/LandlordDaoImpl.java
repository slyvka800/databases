package com.slyvka.DAO.implementation;

import com.slyvka.DAO.LandlordDAO;
import com.slyvka.model.LandlordEntity;
import com.slyvka.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LandlordDaoImpl implements LandlordDAO {
    private static final String FIND_ALL = "SELECT * FROM landlord";
    private static final String DELETE = "DELETE FROM landlord WHERE id=?";
    private static final String CREATE = "INSERT landlord (id, name, surname, money_balance) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE landlord SET name=?, surname=?, money_balance=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM landlord WHERE id=?";

    @Override
    public List<LandlordEntity> findAll() throws SQLException {
        List<LandlordEntity> landlords = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(FIND_ALL)) {
                while(rs.next()) {
                    landlords.add(new LandlordEntity(
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
        return landlords;
    }

    @Override
    public LandlordEntity findById(Integer id) throws SQLException {
        LandlordEntity landlord = null;
        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try(ResultSet rs = statement.executeQuery()) {
                while(rs.next()){
                    landlord = new LandlordEntity(
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

        return landlord;
    }

    @Override
    public void create(LandlordEntity entity) throws SQLException {
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
    public LandlordEntity update(LandlordEntity entity) throws SQLException {
        LandlordEntity prevEntity = findById(entity.getId());

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
    public LandlordEntity delete(Integer id) throws SQLException {
        LandlordEntity entity = findById(id);

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return entity;
    }
}
