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
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String url;
    @Column(name = "isDelete")
    private Boolean isDelete = false;

    @ManyToOne
    @JoinColumn(name = "idProduct")
    private Product product;
}
