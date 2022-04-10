package com.repository;

import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Repository {
    private static Session session = HibernateUtil.getSessionFactory().openSession();

    public <T> T findById(Class<T> o , Integer id) {
        return session.find(o, id);

    }

    public <T> List<T> findAll(Class<T> queryClass) {
        System.out.println("Select all:");
        return session.createQuery("SELECT p FROM " + queryClass.getName() + " p", queryClass).getResultList();
    }

    public void createObject(Object newObject) {
        if (newObject != null) {
            Transaction transaction = session.beginTransaction();
            session.save(newObject);
            transaction.commit();
            System.out.println(newObject + " added.");
        } else {
            System.out.println("New Object not provided!");
        }
    }


    public void updateObject(Object newObject) {
        if (newObject != null) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(newObject);
            transaction.commit();
            System.out.println(newObject + " added.");
        } else {
            System.out.println("New Object not provided!");
        }
    }


    public <T>void removeObjectById(Class<T> o, Integer id) {
        Transaction transaction = session.beginTransaction();
        session.delete(findById(o, id));
    }
}