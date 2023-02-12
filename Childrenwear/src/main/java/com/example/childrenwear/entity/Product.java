package com.example.childrenwear.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;// tên sản phẩm
    private Date date_create;// ngày thêm
    private Date date_update;// ngày cập nhật
    private String image; // hình ảnh
    private Double discount; // giảm giá
    private Double price; // giá tiền
    private Long age_range; // độ tuổi
    private String status; // trạng thái
    private String description;//mô tả
    private String descriptionDetail;//mô tả chi tiết



}
