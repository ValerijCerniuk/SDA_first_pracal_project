package com.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class FlowersForOrdering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flowersForOrderingId;

    private Integer quantity;

    @OneToOne(mappedBy = "flowersForOrdering")
    private Flower flower;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "flowersOrderId")
    private FlowersOrder flowersOrder;
}
