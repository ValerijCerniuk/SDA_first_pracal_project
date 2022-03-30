package com.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class FlowersOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flowersOrderId;

    // private boolean status;
    private String orderDate;
    private String deliveryDay;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flowerOrders")
    private List<Flower> flowers;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;


}
