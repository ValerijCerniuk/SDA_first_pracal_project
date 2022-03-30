package com.primaryData;

import com.model.Customer;
import com.model.Flower;
//import com.model.FlowersForOrdering;
import com.model.FlowersOrder;
import com.repository.Repository;

import java.time.LocalDate;
import java.util.List;


public class PrimaryData {

    public void loadPrimaryData() {

        com.repository.Repository Repository = new Repository();

        Flower roze = Flower.builder()
                .name("Roze")
                .flowerPrice(2)
                .intakeDate("2022, 2, 20")
                .expires(("2022, 3, 10"))
                .color("Red")
                .length(40)
                .amount(50)
                .build();

        Flower tulpe = Flower.builder()
                .name("Tulpe")
                .flowerPrice(1)
                .intakeDate("2022, 2, 22")
                .expires("2022, 3, 5")
                .color("Red")
                .length(20)
                .amount(40)
                .build();

        Repository.updateObject(roze);
        Repository.updateObject(tulpe);

        Customer jonas = Customer.builder()
                .fullName("Jonas Jonaitis")
                .email("jonas@org.com")
                .phoneNumber("223658")
                .billingAddress("Address 1")
                .build();

        FlowersOrder jonasOrder1 = FlowersOrder.builder()
                .customer(jonas)
                .orderDate("2022, 3, 5")
                .deliveryDay("2022, 3, 15")
                .build();

        FlowersOrder jonasOrder2 = FlowersOrder.builder()
                .customer(jonas)
                .orderDate("2022, 4, 1")
                .deliveryDay("2022, 4, 10")
                .build();

        jonas.setOrders(List.of(jonasOrder1, jonasOrder2));

//        FlowersForOrdering jonasFlowers1 = FlowersForOrdering.builder()
//                .flowersOrder(jonasOrder1)
//                .flower(roze)
//                .quantity(3)
//                .build();
//
//        jonasOrder1.setFlowersForOrderings(List.of(jonasFlowers1));
//
//        FlowersForOrdering jonasFlowers2 = FlowersForOrdering.builder()
//                .flowersOrder(jonasOrder1)
//                .flower(tulpe)
//                .quantity(5)
//                .build();
//
//        jonasOrder1.setFlowersForOrderings(List.of(jonasFlowers1, jonasFlowers2));
//
//        FlowersForOrdering jonasFlowers3 = FlowersForOrdering.builder()
//                .flowersOrder(jonasOrder2)
//                .flower(tulpe)
//                .quantity(5)
//                .build();
//
//        jonasOrder2.setFlowersForOrderings(List.of(jonasFlowers3));

        Repository.updateObject(jonas);

    }
}
