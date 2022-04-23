package com;

import com.model.Customer;
import com.model.Flower;
import com.primaryData.PrimaryData;
import com.repository.Repository;


public class Main {
    public static void main(String[] args) {

        new PrimaryData().loadPrimaryData();

        Repository repository = new Repository();
        repository.findAll( Flower.class).forEach(System.out::println);

        System.out.println();
        System.out.println(repository.findById(Flower.class, 1));

    }
}
