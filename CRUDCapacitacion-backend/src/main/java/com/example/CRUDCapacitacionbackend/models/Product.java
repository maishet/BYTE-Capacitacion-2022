package com.example.CRUDCapacitacionbackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Getter @Setter @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ProductID;
    @Getter @Setter @Column(length = 40)
    private String ProductName;
    @Getter @Setter @ManyToOne(fetch = FetchType.EAGER)
    private Supplier supplier;
    @Getter @Setter @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
    @Getter @Setter
    private String QuantityPerUnit;
    @Getter @Setter
    private BigDecimal UnitPrice;
    @Getter @Setter
    private short UnitsInStock;
    @Getter @Setter
    private short UnitsOnOrder;
    @Getter @Setter
    private short ReorderLevel;
    @Getter @Setter
    private boolean Discontinued;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "product")
    private Set<Order_detail> orderdetailproduct = new HashSet<>();
}
