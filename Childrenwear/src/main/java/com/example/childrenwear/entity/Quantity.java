package com.example.childrenwear.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "quantity")
public class Quantity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quantity; // số lượng
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
}
