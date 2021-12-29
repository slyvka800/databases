package com.slyvka.DAO;

import com.slyvka.DAO.Interfaces.GeneralDAO;
import com.slyvka.model.StreetEntity;
import com.slyvka.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StreetDaoImpl implements GeneralDAO<StreetEntity, String> {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<StreetEntity> findAll() throws SQLException {
        List entities = new ArrayList<>();

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            entities = session.createQuery("from StreetEntity ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public StreetEntity findById(String name) throws SQLException {
        StreetEntity entity = null;

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            entity = session.get(StreetEntity.class, name);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public void create(StreetEntity entity) throws SQLException {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
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
