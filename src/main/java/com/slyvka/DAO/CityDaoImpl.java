package com.slyvka.DAO;

import com.slyvka.DAO.Interfaces.GeneralDAO;
import com.slyvka.model.CityEntity;
import com.slyvka.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl implements GeneralDAO<CityEntity, String> {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<CityEntity> findAll() throws SQLException {
        List<CityEntity> entities = new ArrayList<>();

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            entities = session.createQuery("from CityEntity ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public CityEntity findById(String name) throws SQLException {
        CityEntity entity = null;

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            entity = session.get(CityEntity.class, name);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public void create(CityEntity entity) throws SQLException {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public CityEntity update(CityEntity entity) throws SQLException {
        CityEntity prevEntity = null;

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            prevEntity = session.get(CityEntity.class, entity.getName());
            session.getTransaction().commit();
            session.clear();

            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return prevEntity;
    }

    @Override
    public CityEntity delete(String name) throws SQLException {
        CityEntity entity = null;

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            entity = session.get(CityEntity.class, name);
            if (entity != null) {
                session.delete(entity);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }
}
