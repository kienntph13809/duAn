package com.example.datn_2023.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "category_lv2")
public class Category_lv2 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "isDelete")
    private Boolean isDelete = false;
    @ManyToOne
    @JoinColumn(name = "idcategory")
    private Category category;
    @OneToMany(mappedBy = "categorylv2")
    private List<Product> products;
}
