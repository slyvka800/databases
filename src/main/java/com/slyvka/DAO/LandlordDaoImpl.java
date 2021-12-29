package com.slyvka.DAO;

import com.slyvka.DAO.Interfaces.GeneralDAO;
import com.slyvka.model.LandlordEntity;
import com.slyvka.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LandlordDaoImpl implements GeneralDAO<LandlordEntity, Integer> {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<LandlordEntity> findAll() throws SQLException {
        List entities = new ArrayList<LandlordEntity>();

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            entities = session.createQuery("from LandlordEntity").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public LandlordEntity findById(Integer id) throws SQLException {
        LandlordEntity entity = null;

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            entity = session.get(LandlordEntity.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public void create(LandlordEntity entity) throws SQLException {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LandlordEntity update(LandlordEntity entity) throws SQLException {
        LandlordEntity prevEntity = null;

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            prevEntity = session.get(LandlordEntity.class, entity.getId());
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
    public LandlordEntity delete(Integer id) throws SQLException {
        LandlordEntity entity = null;

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            entity = session.get(LandlordEntity.class, id);
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
