package com.slyvka.DAO;

import com.slyvka.DAO.Interfaces.TenantDAO;
import com.slyvka.model.TenantEntity;
import com.slyvka.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TenantDaoImpl implements TenantDAO {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<TenantEntity> findAll() throws SQLException {
        List entities = new ArrayList<>();

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            entities = session.createQuery("from TenantEntity ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public TenantEntity findById(Integer id) throws SQLException {
        TenantEntity entity = null;

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            entity = session.get(TenantEntity.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public TenantEntity findByName(String name) throws SQLException {
        TenantEntity entity = null;

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            entity = session.get(TenantEntity.class, name);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public TenantEntity findBySurname(String surname) throws SQLException {
        TenantEntity entity = null;

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            entity = session.get(TenantEntity.class, surname);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public void create(TenantEntity entity) throws SQLException {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public TenantEntity update(TenantEntity entity) throws SQLException {
        TenantEntity prevEntity = findById(entity.getId());

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            prevEntity = session.get(TenantEntity.class, entity.getId());
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
    public TenantEntity delete(Integer id) throws SQLException {
        TenantEntity entity = null;
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            entity = session.get(TenantEntity.class, id);
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
