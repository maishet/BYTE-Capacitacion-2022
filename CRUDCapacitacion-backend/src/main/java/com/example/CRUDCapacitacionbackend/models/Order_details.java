package com.example.CRUDCapacitacionbackend.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order details")
public class Order_details {
    @Id @Getter @Setter @GeneratedValue(strategy = GenerationType.AUTO)
    private int OrderID;
    @Getter @Setter @GeneratedValue(strategy = GenerationType.AUTO)
    private int ProductID;
    @Getter @Setter @NonNull
    private BigDecimal UnitPrice;
    @Getter @Setter @NonNull
    private short Quantity;
    @Getter @Setter @NonNull
    private float Discount;
}
