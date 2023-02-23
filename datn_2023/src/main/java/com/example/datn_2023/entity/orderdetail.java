package com.example.datn_2023.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;

import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "orderdetail")
public class orderdetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;//giá gốc
    private Double downprice;//giá giảm
    private Long quantitydetail;//số lượng mua
    private Double intomoney;//thành tiền

}
