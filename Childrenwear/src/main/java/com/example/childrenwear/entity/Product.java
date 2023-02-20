package com.example.childrenwear.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    @Column(name = "isDelete")
    private Boolean isDelete = false;
    @ManyToOne
    @JoinColumn(name = "idCategorylv2")
    private Category_lv2 categorylv2;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Quantity> quantities;
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Image> list_Images;

}
