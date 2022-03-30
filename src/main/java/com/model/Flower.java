package com.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flowerId;
    private String name;
    private Double price;
    private Double length;
    private String color;
    private String intakeDate;
    private String  expires;
    private Integer amount;
//     private Integer suppler_id;

    @ManyToOne
    @JoinColumn(name = "flowerOrder_id")
    private FlowersOrder flowerOrders;
}