package com.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class FlowersOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flowerOrder_id;

    // private boolean status;
    private String orderDate;
    private String orderDeadlineDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flowerOrders")
    private List<Flower> flowers;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
