package com.example.CRUDCapacitacionbackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_details")
public class Order_detail {
    @Id
    @Getter @Setter @GeneratedValue(strategy = GenerationType.AUTO) //@ManyToOne(fetch = FetchType.EAGER)
    private int OrderID;
    @Getter @Setter @ManyToOne(fetch = FetchType.EAGER)
    private Product product;
    @Getter @Setter
    private BigDecimal UnitPrice;
    @Getter @Setter
    private short Quantity;
    @Getter @Setter
    private float Discount;
}
