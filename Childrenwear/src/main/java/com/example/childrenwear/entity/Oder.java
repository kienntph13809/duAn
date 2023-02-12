package com.example.childrenwear.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "oder")
public class Oder implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    private double discount; // giảm giá
    private double downtotal; // giá sau khi giảm
    private double fullname;
    private double note;
    private boolean payment;// thanh toán bằng gì flase mua hàng r thanh toán, true thanh toán bằng ví
    private double refund;
    private double phonenumber;
    private double status;// trạng thái
    private double statusshipping; // trạng thái giao hàng
    private double total; //thanh toán
    private double transportFee; // phí vận chuyển
    private String address;//địa chỉ






}
