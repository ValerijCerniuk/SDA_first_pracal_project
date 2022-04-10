package com.repository;


import com.model.Customer;
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
            .flowerPrice(10)
            .color("TestColor")
            .build();
    repository.updateObject(roze);
}
//@BeforeAll
//    public static void setUpCustomer(){
//        Customer roze = Customer.builder()
//                .fullName("Test Customer Name")
//                .email("Test Email")
//                .phoneNumber(("Test Phone"))
//                .billingAddress("Test address")
//                .build();
//        repository.updateObject(roze);
//    }

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

        Flower flower = Flower.builder()
                .name("TestFlower")
                .flowerPrice(10)
                .color("TestColor")
                .build();
       Integer id = (Integer) session.save(flower);

        session.getTransaction().commit();

        Assertions.assertTrue(id > 0);
    }

    @Test
    void updateObject() {
        System.out.println("Running testUpdate...");

        Integer id = 1;
        Flower product = Flower.builder()
                .name("TestFlower")
                .flowerPrice(10)
                .color("TestColor")
                .build();

        session.beginTransaction();
        repository.updateObject(product);
        session.getTransaction().commit();

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