package com;

import com.model.Customer;
import com.model.Flower;
import com.primaryData.PrimaryData;
import com.repository.Repository;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        new PrimaryData().loadPrimaryData();

//        FlowerRepository flowerRepository = new FlowerRepository();
//
//        Flower roze = Flower.builder()
//                .name("Roze")
//                .flowerPrice(10)
//                .build();
//
//        flowerRepository.createFlower(roze);
    }
}
