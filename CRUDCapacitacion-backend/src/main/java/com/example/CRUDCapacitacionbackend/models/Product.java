package com.example.CRUDCapacitacionbackend.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products", indexes = @Index(columnList = "ProductName"))
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
    @Getter @Setter @Column(columnDefinition = "decimal(19,2) default 0")
    private BigDecimal UnitPrice;
    @Getter @Setter @Column(columnDefinition = "smallint default 0")
    private short UnitsInStock;
    @Getter @Setter @Column(columnDefinition = "smallint default 0")
    private short UnitsOnOrder;
    @Getter @Setter @Column(columnDefinition = "smallint default 0")
    private short ReorderLevel;
    @Getter @Setter @Column(columnDefinition = "bit(1) default 0")
    private boolean Discontinued;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "product")
    private List<Order_detail> orderdetailproduct;
    //private Set<Order_detail> orderdetailproduct = new HashSet<>();
}
