package com.example.datn_2023.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "quantity")
public class Quantity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long quantity;
    @ManyToOne
    @JoinColumn(name = "idproduct", updatable = false, insertable = false)
    private Product product;
    @Column(name = "idproduct")
    private Long idProduct;
    @ManyToOne
    @JoinColumn(name = "idsize", updatable = false, insertable = false)
    private Size size;

    @Column(name = "idsize")
    private Long idsize;

    @ManyToOne
    @JoinColumn(name = "idproperty", updatable = false, insertable = false)
    private Property property;

    @Column(name = "idproperty")
    private Long idproperty;

    @Column(name = "isDelete")
    private Boolean isDelete = false;


}
