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
    @Getter @Setter @Column(columnDefinition = "decimal(19,2) default 0")
    private BigDecimal UnitPrice;
    @Getter @Setter @Column(columnDefinition = "smallint default 1")
    private short Quantity;
    @Getter @Setter @Column(columnDefinition = "float default 0")
    private float Discount;
}
