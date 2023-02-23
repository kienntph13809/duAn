package com.example.datn_2023.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "direactSale")
public class DireactSale implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date DateOfSale;//Ngày hóa đơn được tạo
    private Double TotalAmount; //Tổng số tiền khách hàng phải trả cho các sản phẩm được mua.
    private String PaymentMethod;//Hình thức thanh toán, ví dụ: tiền mặt, thẻ tín dụng, v.v.
    private Double discount; // giảm giá



}
