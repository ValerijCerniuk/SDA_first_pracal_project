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
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String billingAddress;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<FlowersOrder> orders;
}
