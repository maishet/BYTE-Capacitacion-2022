package com.example.CRUDCapacitacionbackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "orders", indexes = {
        @Index(columnList = "OrderDate"),
        @Index(columnList = "ShippedDate"),
        @Index(columnList = "ShipPostalCode")
})
public class Order {
    @Id
    @Getter @Setter @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OrderID;
    @Getter @Setter @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;
    @Getter @Setter @ManyToOne(fetch = FetchType.EAGER)
    private Employee employee;
    @Getter @Setter
    private Date OrderDate;
    @Getter @Setter
    private Date RequiredDate;
    @Getter @Setter
    private Date ShippedDate;
    @Getter @Setter @ManyToOne(fetch = FetchType.EAGER)
    private Shipper shipper;
    @Getter @Setter
    private BigDecimal Freight;
    @Getter @Setter @Column(length = 40)
    private String ShipName;
    @Getter @Setter @Column(length = 60)
    private String ShipAddress;
    @Getter @Setter @Column(length = 15)
    private String ShipCity;
    @Getter @Setter @Column(length = 15)
    private String ShipRegion;
    @Getter @Setter @Column(length = 10)
    private String ShipPostalCode;
    @Getter @Setter @Column(length = 15)
    private String ShipCountry;

    //@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "order")
    //private List<Order_detail> orderdetailorders;
    //private Set<Order_detail> orderdetailorders = new HashSet<>();
}
