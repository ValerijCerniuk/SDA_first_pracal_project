package com.primaryData;

import com.model.Customer;
import com.model.Flower;
import com.model.FlowersOrder;
import com.repository.Repository;


import java.util.List;


public class PrimaryData {

    public void loadPrimaryData() {

        com.repository.Repository Repository = new Repository();

        Flower roze = Flower.builder()
                .name("Roze")
                .flowerPrice(2)
                .color("Red")
                .build();

        Flower tulpe = Flower.builder()
                .name("Tulpe")
                .flowerPrice(1)
                .color("Red")
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
                .flowers(List.of(roze,tulpe))
                .build();

        FlowersOrder jonasOrder2 = FlowersOrder.builder()
                .customer(jonas)
                .orderDate("2022, 4, 1")
                .deliveryDay("2022, 4, 10")
                .build();

        roze.setFlowersOrder(jonasOrder1);
        tulpe.setFlowersOrder(jonasOrder1);
        jonas.setFlowersOrders(List.of(jonasOrder1, jonasOrder2));

        Repository.updateObject(jonas);

    }
}
