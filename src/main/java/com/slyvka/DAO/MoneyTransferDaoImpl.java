package com.slyvka.DAO;

import com.slyvka.DAO.Interfaces.MoneyTransferDao;
import com.slyvka.model.MoneyTransferEntity;
import com.slyvka.model.MoneyTransferEntityPK;
import com.slyvka.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MoneyTransferDaoImpl implements MoneyTransferDao {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<MoneyTransferEntity> findAll() throws SQLException {
        List<MoneyTransferEntity> entities = new ArrayList<>();

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            entities = session.createQuery("from MoneyTransferEntity").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public MoneyTransferEntity findById(Integer id, Integer landlordId, Integer tenantId) throws SQLException {
        MoneyTransferEntity entity = null;

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            entity = session.get(MoneyTransferEntity.class, new MoneyTransferEntityPK(id, landlordId, tenantId));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public void create(MoneyTransferEntity entity) throws SQLException {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public MoneyTransferEntity update(MoneyTransferEntity entity) throws SQLException {
        MoneyTransferEntity prevEntity = null;

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            prevEntity = session.get(MoneyTransferEntity.class, new MoneyTransferEntityPK(entity.getId(),
                    entity.getLandlordId(), entity.getTenantId()));
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
    public MoneyTransferEntity delete(Integer id, Integer landlordId, Integer tenantId) throws SQLException {
        MoneyTransferEntity entity = null;

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            entity = session.get(MoneyTransferEntity.class, new MoneyTransferEntityPK(id, landlordId, tenantId));
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
