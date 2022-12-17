package com.example.CRUDCapacitacionbackend.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Products {
    @Id @Getter @Setter @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ProductID;
    @Getter @Setter @Column(length = 40) @NonNull
    private String ProductName;
    @Getter @Setter
    private int SupplierID;
    @Getter @Setter
    private int CategoryID;
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

}
