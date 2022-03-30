package com.repository;


import com.model.Flower;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RepositoryTest {
    private static Session session = HibernateUtil.getSessionFactory().openSession();
    private static SessionFactory sessionFactory = null;
    private static Repository repository = new Repository();

    // tikriausei reikia atidarit ir uzdarit sesija su @BeforeEach
@BeforeAll
public static void setUpFlower(){
    Flower roze = Flower.builder()
            .name("TestFlower")
            .price(10.0)
            .intakeDate("TestDate1")
            .expires(("TestaDate2"))
            .color("TestColor")
            .length(10.0)
            .amount(10)
            .build();
    repository.updateObject(roze);
}

    @Test
    void findById() {
        System.out.println("Running testGet...");

        Integer id = 1;

        Flower flower = repository.findById(Flower.class, id);

        assertEquals("TestFlower", flower.getName());
    }

    @Test
    void findAll() {
        System.out.println("Running testList...");

        Query<Flower> query = session.createQuery("from Flower ", Flower.class);
        List<Flower> resultList = query.getResultList();

        Assertions.assertFalse(resultList.isEmpty());
    }

    @Test
    void createFlower() {
        System.out.println("Running testCreate...");

        session.beginTransaction();
        Flower flower = new Flower(null, "Test2", 20.0, 20.0,"TestColor2",
                "Date", "Date", 20, null);
        Integer id = (Integer) session.save(flower);

        session.getTransaction().commit();

        Assertions.assertTrue(id > 0);
    }

    @Test
    void updateObject() {
        System.out.println("Running testUpdate...");

        Integer id = 1;

        Flower updatedProduct = repository.findById(Flower.class, id);

        assertEquals("TestFlower", updatedProduct.getName());
    }

    @Test
    void removeObjectById() {
        System.out.println("Running testDelete...");

        Integer id = 1;

       repository.removeObjectById(Flower.class, id);

        Flower deletedProduct = repository.findById(Flower.class, id);

        Assertions.assertNull(deletedProduct);
    }

}