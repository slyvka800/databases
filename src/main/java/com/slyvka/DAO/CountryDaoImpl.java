package com.slyvka.DAO;

import com.slyvka.DAO.Interfaces.GeneralDAO;
import com.slyvka.model.CityEntity;
import com.slyvka.model.CountryEntity;
import com.slyvka.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl implements GeneralDAO<CountryEntity, String> {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


    @Override
    public List<CountryEntity> findAll() throws SQLException {
        List entities = new ArrayList<>();

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            entities = session.createQuery("from CountryEntity ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public CountryEntity findById(String name) throws SQLException {
        CountryEntity entity = null;

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            entity = session.get(CountryEntity.class, name);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public void create(CountryEntity entity) throws SQLException {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
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
