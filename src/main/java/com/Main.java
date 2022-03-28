package com;

import com.model.Customer;
import com.model.Flower;
import com.primaryData.PrimaryData;
import com.repository.Repository;

import static com.repository.SQLQueries.SELECT_ALL_FLOWERS;
import static com.repository.SQLQueries.SELECT_ALL_FLOWER_BY_ID;

public class Main {
    public static void main(String[] args) {

        new PrimaryData().loadPrimaryData();

        Repository repository = new Repository();
        repository.findAll(SELECT_ALL_FLOWERS, Flower.class)
                .stream().forEach(System.out::println);

        System.out.println();
        System.out.println(repository.findById(SELECT_ALL_FLOWER_BY_ID, Flower.class, 1));

    }
}
