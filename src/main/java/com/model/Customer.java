package com.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String billingAddress;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<FlowersOrder> flowersOrders;
}
