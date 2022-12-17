package com.example.CRUDCapacitacionbackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
public class Orders {
    @Id @Getter @Setter @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OrderID;
    @Getter @Setter @Column(length = 5)
    private String CustomerID;
    @Getter @Setter
    private int EmployeeID;
    @Getter @Setter
    private Timestamp OrderDate;
    @Getter @Setter
    private Timestamp RequiredDate;
    @Getter @Setter
    private Timestamp ShippedDate;
    @Getter @Setter
    private int ShipVia;
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
}
