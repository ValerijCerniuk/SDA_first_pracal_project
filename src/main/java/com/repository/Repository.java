package com.repository;

import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Repository {
    private static Session session = HibernateUtil.getSessionFactory().openSession();

    public <T> List<T> findAll(String SQLQuery, Class<T> queryClass) {
        return session.createQuery(SQLQuery, queryClass).getResultList();
    }

    public <T> T findById(String SQLQuery, Class<T> queryClass, Integer id) {
        return session.createQuery(SQLQuery, queryClass)
                .setParameter("id", id)
                .getSingleResult();
    }

    public <T> void createOrUpdateRecord(T recordToAdd) {
        if (recordToAdd != null) {
            Transaction transaction = session.beginTransaction();
            session.save(recordToAdd);
            transaction.commit();
            System.out.println(recordToAdd + " was saved");
        } else {
            System.out.println(recordToAdd + "was not saved!");
        }
    }

}
