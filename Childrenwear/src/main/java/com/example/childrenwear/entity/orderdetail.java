package com.example.childrenwear.entity;

import jakarta.persistence.*;
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
