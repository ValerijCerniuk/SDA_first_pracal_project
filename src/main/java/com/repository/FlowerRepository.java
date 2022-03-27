package com.repository;

import com.util.HibernateUtil;
import org.hibernate.Session;

public class FlowerRepository {
    private static Session session = HibernateUtil.getSessionFactory().openSession();


}
